package com.rabt.healthycollection.base;


import android.app.Activity;
import android.app.Application;

import com.github.moduth.blockcanary.BlockCanary;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Settings;
import com.rabt.healthycollection.BuildConfig;
import com.rabt.healthycollection.base.di.component.AppComponent;
import com.rabt.healthycollection.base.di.component.DaggerAppComponent;
import com.rabt.healthycollection.base.di.module.AppModule;
import com.rabt.healthycollection.base.exception.CrashHandler;
import com.squareup.leakcanary.LeakCanary;

import java.util.HashSet;
import java.util.Set;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public class App extends Application {

    private static App instance;
    private Set<Activity> activities;

    public static synchronized App getInstance() {
        return instance;
    }

    public static AppComponent getAppComponent() {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(instance))
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        //初始化日志收集
        Settings settings = Logger.init(getPackageName());
        if (!BuildConfig.DEBUG) {
            settings.logLevel(LogLevel.NONE);
        }
        //崩溃日志收集
        CrashHandler.init(new CrashHandler(this));
        //内存泄漏检查
        LeakCanary.install(this);
        //过渡绘制检查
        BlockCanary.install(this, new AppBlockCanaryContext()).start();
    }

    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new HashSet<>();
        }
        activities.add(activity);
    }

    public void removeActvity(Activity activity) {
        if (activities != null) {
            activities.remove(activity);
        }
    }

    public void exitApp() {
        if (activities != null) {
            synchronized (activities) {
                for (Activity activity : activities) {
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
