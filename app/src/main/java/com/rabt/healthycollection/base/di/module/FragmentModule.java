package com.rabt.healthycollection.base.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.rabt.healthycollection.base.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

@FragmentScope
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        this.mFragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity getActivity() {
        return mFragment.getActivity();
    }
}
