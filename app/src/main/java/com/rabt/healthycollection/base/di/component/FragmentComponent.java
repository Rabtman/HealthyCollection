package com.rabt.healthycollection.base.di.component;

import android.app.Activity;

import com.rabt.healthycollection.base.di.module.FragmentModule;
import com.rabt.healthycollection.base.di.scope.FragmentScope;
import com.rabt.healthycollection.ui.health.HealthNewsItemFragment;
import com.rabt.healthycollection.ui.hospital.HospitalMainFragment;

import dagger.Component;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    Activity getActivity();

    void inject(HealthNewsItemFragment fragment);

    void inject(HospitalMainFragment fragment);
}
