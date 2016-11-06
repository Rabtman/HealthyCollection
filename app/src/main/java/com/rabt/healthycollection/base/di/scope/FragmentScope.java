package com.rabt.healthycollection.base.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
