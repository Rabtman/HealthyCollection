package com.rabt.healthycollection.base;

import javax.inject.Inject;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment implements BaseView {

    @Inject
    protected T mPresenter;


    protected abstract void inject();

    protected abstract int getLayout();

    protected abstract void initData();
}
