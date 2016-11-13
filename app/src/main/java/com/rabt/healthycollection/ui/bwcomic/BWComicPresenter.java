package com.rabt.healthycollection.ui.bwcomic;

import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.base.constant.BWComicType;
import com.rabt.healthycollection.base.http.RetrofitManager;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description:
 */

public class BWComicPresenter extends RxPresenter<BWComicContract.View> implements BWComicContract.Presenter {

    private RetrofitManager mRetrofitManager;
    private int currentPage = 1;

    @Inject
    public BWComicPresenter(RetrofitManager retrofitManager) {
        this.mRetrofitManager = retrofitManager;
    }

    //获取漫画列表
    public void getBWComicList() {
        Subscription subscription = mRetrofitManager.getBWComicListInfo(BWComicType.GSMH, currentPage)
                .compose(RxUtil.<ShowApiResponse<BWComicPage>>rxSchedulerHelper())
                .compose(RxUtil.<BWComicPage>handleShowApiResult())
                .subscribe(new Action1<BWComicPage>() {
                    @Override
                    public void call(BWComicPage bwComicPage) {

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
        addSubscribe(subscription);
    }
}
