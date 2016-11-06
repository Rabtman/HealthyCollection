package com.rabt.healthycollection.base.di.module;

import android.app.Activity;

import com.rabt.healthycollection.base.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
