package com.rabt.healthycollection.base;


import android.app.Activity;
import android.app.Application;

import com.rabt.healthycollection.base.di.component.AppComponent;
import com.rabt.healthycollection.base.di.component.DaggerAppComponent;
import com.rabt.healthycollection.base.di.module.AppModule;

import java.util.Set;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public class App extends Application {

    private static App instance;
    private Set<Activity> actvities;

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

    }

    public void addActivity(Activity activity) {
        actvities.add(activity);
    }

    public void removeActvity(Activity activity) {
        if (actvities != null) {
            actvities.remove(activity);
        }
    }

    public void exitApp() {
        if (actvities != null) {
            synchronized (actvities) {
                for (Activity activity : actvities) {
                    activity.finish();
                }
            }
        }
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }
}
