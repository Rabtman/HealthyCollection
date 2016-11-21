package com.rabt.healthycollection.base.di.module;

import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.http.RetrofitManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

@Module
public class AppModule {

    private final App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides
    @Singleton
    App provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    RetrofitManager provideRetrofitManager() {
        return new RetrofitManager();
    }

    @Provides
    @Singleton
    HealthService provideBWComicService(RetrofitManager retrofitManager) {
        return new HealthService(retrofitManager);
    }
}
