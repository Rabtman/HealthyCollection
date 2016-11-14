package com.rabt.healthycollection.ui.bwcomic.presenter;

import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.base.http.RetrofitManager;
import com.rabt.healthycollection.constant.BWComicConstant;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;
import com.rabt.healthycollection.ui.bwcomic.view.BWComicView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description:
 */

public class BWComicPresenter extends RxPresenter<BWComicView> {

    private RetrofitManager mRetrofitManager;
    private int currentPage = 1;

    @Inject
    public BWComicPresenter(RetrofitManager retrofitManager) {
        mRetrofitManager = retrofitManager;
    }

    //获取漫画列表
    public void getBWComicList() {
        currentPage = 1;
        Subscription subscription = mRetrofitManager.getBWComicListInfo(BWComicConstant.Type.GAOXIAO, currentPage)
                .compose(RxUtil.<ShowApiResponse<BWComicPage>>rxSchedulerHelper())
                .compose(RxUtil.<BWComicPage>handleShowApiResult())
                .subscribe(new Action1<BWComicPage>() {
                    @Override
                    public void call(BWComicPage bwComicPage) {
                        mView.showContent(bwComicPage.getPage().getContentlist());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError("数据加载失败！");
                    }
                });
        addSubscribe(subscription);
    }

    //加载更多
    public void getMoreBWComicList() {
        Subscription subscription = mRetrofitManager.getBWComicListInfo(BWComicConstant.Type.GAOXIAO, ++currentPage)
                .compose(RxUtil.<ShowApiResponse<BWComicPage>>rxSchedulerHelper())
                .compose(RxUtil.<BWComicPage>handleShowApiResult())
                .subscribe(new Action1<BWComicPage>() {
                    @Override
                    public void call(BWComicPage bwComicPage) {
                        mView.showMoreContent(bwComicPage.getPage().getContentlist(), bwComicPage.getPage().isHasMore());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        --currentPage;
                        mView.showError("数据加载失败！");
                    }
                });
        addSubscribe(subscription);
    }
}
