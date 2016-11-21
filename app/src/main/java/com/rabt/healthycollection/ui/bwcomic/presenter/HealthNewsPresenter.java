package com.rabt.healthycollection.ui.bwcomic.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;
import com.rabt.healthycollection.ui.bwcomic.view.HealthNewsView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description:
 */

public class HealthNewsPresenter extends RxPresenter<HealthNewsView> {

    private HealthService healthService;
    private int currentPage = 1;

    @Inject
    public HealthNewsPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    //获取漫画列表
    public void getHealthList() {
        currentPage = 1;
        Subscription subscription = healthService.getHealthListInfo(1, "", currentPage)
                .compose(RxUtil.<ShowApiResponse<HealthNewsPage>>rxSchedulerHelper())
                .compose(RxUtil.<HealthNewsPage>handleShowApiResult())
                .subscribe(new Action1<HealthNewsPage>() {
                    @Override
                    public void call(HealthNewsPage healthNewsPage) {
                        mView.showContent(healthNewsPage.getPage().getContentlist());
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError(App.getInstance().getString(R.string.msg_load_err));
                    }
                });
        addSubscribe(subscription);
    }

    //加载更多
    public void getMoreHealthList() {
        Subscription subscription = healthService.getHealthListInfo(1, "", ++currentPage)
                .compose(RxUtil.<ShowApiResponse<HealthNewsPage>>rxSchedulerHelper())
                .compose(RxUtil.<HealthNewsPage>handleShowApiResult())
                .subscribe(new Action1<HealthNewsPage>() {
                    @Override
                    public void call(HealthNewsPage healthNewsPage) {
                        mView.showMoreContent(healthNewsPage.getPage().getContentlist(),
                                healthNewsPage.getPage().getCurrentPage() < healthNewsPage.getPage().getAllPages());  //判断是否有下一页
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        --currentPage;
                        mView.showError(App.getInstance().getString(R.string.msg_load_err));
                    }
                });
        addSubscribe(subscription);
    }
}
