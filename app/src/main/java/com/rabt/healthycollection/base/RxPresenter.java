package com.rabt.healthycollection.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description: 基于Rx的Presenter封装,控制订阅的生命周期
 */

public class RxPresenter<T extends BaseView> implements BasePresenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubcription;

    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubcription == null) {
            mCompositeSubcription = new CompositeSubscription();
        }
        mCompositeSubcription.add(subscription);
    }

    protected void unSubscribe() {
        if (mCompositeSubcription != null) {
            mCompositeSubcription.unsubscribe();
        }
    }

    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
