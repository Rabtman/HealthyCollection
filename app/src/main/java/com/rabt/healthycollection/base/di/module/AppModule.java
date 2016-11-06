package com.rabt.healthycollection.base.di.module;

import com.rabt.healthycollection.base.App;

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
}
