package com.rabt.healthycollection.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rabt.healthycollection.base.di.component.ActivityComponent;
import com.rabt.healthycollection.base.di.component.DaggerActivityComponent;
import com.rabt.healthycollection.base.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public abstract class BaseActivity<T extends BasePresenter> extends SupportActivity implements BaseView {

    @Inject
    protected T mPresenter;
    protected Activity mContext;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);
        mContext = this;
        inject();
        if (mPresenter != null) mPresenter.attachView(this);
        App.getInstance().addActivity(this);
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    protected void setToolBar(Toolbar toolBar, String title) {
        if (toolBar == null) return;
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(title);
        toolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressedSupport();
            }
        });
    }

    protected ActivityComponent getActivityComponent() {
        return DaggerActivityComponent.builder()
                .appComponent(App.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
        mUnbinder.unbind();
        App.getInstance().removeActvity(this);
    }

    protected abstract void inject();

    protected abstract int getLayout();

    protected abstract void initData();
}
