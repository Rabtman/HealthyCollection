package com.rabt.healthycollection.base.di.component;

import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.di.module.AppModule;
import com.rabt.healthycollection.base.http.RetrofitManager;

import javax.inject.Singleton;

import dagger.Component;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    App getContext();    //提供app的context

    RetrofitManager retrofitManager();   //提供retrofit
}
