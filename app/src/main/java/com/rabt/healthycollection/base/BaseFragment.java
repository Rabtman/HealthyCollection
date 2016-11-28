package com.rabt.healthycollection.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rabt.healthycollection.base.di.component.DaggerFragmentComponent;
import com.rabt.healthycollection.base.di.component.FragmentComponent;
import com.rabt.healthycollection.base.di.module.FragmentModule;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment implements BaseView {

    @Inject
    protected T mPresenter;
    protected View mView;
    protected Activity mActivity;
    protected Context mContext;
    protected boolean isInited = false;
    protected ProgressDialog progressDialog;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        mActivity = (Activity) context;
        mContext = context;
        super.onAttach(context);
    }

    protected FragmentComponent getFragmentComponent() {
        return DaggerFragmentComponent.builder()
                .appComponent(App.getAppComponent())
                .fragmentModule(new FragmentModule(this))
                .build();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(getLayout(), container, false);
        inject();
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mUnbinder = ButterKnife.bind(this, view);
        initProgressDialog(getContext());

        if (savedInstanceState == null) {
            if (!isHidden()) {
                isInited = true;
                initData();
            }
        } else {
            if (!isSupportHidden()) {
                isInited = true;
                initData();
            }
        }
    }

    public void initProgressDialog(Context context) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("");
        progressDialog.setMessage("加载中...");
        progressDialog.setCanceledOnTouchOutside(false);
    }

    public void showProgress() {
        if (progressDialog != null && !progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    public void stopProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!isInited && !hidden) {
            isInited = true;
            initData();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.detachView();
    }

    protected abstract void inject();

    protected abstract int getLayout();

    protected abstract void initData();
}
