package com.rabt.healthycollection.base.di.component;

import android.app.Activity;

import com.rabt.healthycollection.base.di.module.ActivityModule;
import com.rabt.healthycollection.base.di.scope.ActivityScope;

import dagger.Component;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();
}