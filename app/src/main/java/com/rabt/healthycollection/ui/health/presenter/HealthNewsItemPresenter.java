package com.rabt.healthycollection.ui.health.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.ui.health.view.HealthNewsView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description:
 */

public class HealthNewsItemPresenter extends RxPresenter<HealthNewsView> {

    private HealthService healthService;
    private int currentPage = 1;

    @Inject
    public HealthNewsItemPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    //获取漫画列表
    public void getHealthList(int id) {
        currentPage = 1;
        Subscription subscription = healthService.getHealthListInfo(id, currentPage)
                .compose(RxUtil.<HealthNewsPage>rxSchedulerHelper())
                .subscribe(new Action1<HealthNewsPage>() {
                    @Override
                    public void call(HealthNewsPage healthNewsPage) {
                        mView.showContent(healthNewsPage.getHealthNewsList());
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
    public void getMoreHealthList(int id) {
        Subscription subscription = healthService.getHealthListInfo(id, ++currentPage)
                .compose(RxUtil.<HealthNewsPage>rxSchedulerHelper())
                .subscribe(new Action1<HealthNewsPage>() {
                    @Override
                    public void call(HealthNewsPage healthNewsPage) {
                        mView.showMoreContent(healthNewsPage.getHealthNewsList(),
                                (healthNewsPage.getHealthNewsList() != null && healthNewsPage.getHealthNewsList().size() > 0));  //判断是否有下一页
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
