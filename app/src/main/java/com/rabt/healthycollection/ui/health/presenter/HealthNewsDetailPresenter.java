package com.rabt.healthycollection.ui.health.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.ui.health.view.HealthNewsDetailView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/14
 */

public class HealthNewsDetailPresenter extends RxPresenter<HealthNewsDetailView> {

    private HealthService healthService;

    @Inject
    public HealthNewsDetailPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    public void getHealthNewsDetail(int id) {
        if (id == -1) {
            mView.showError(App.getInstance().getString(R.string.msg_load_err));
            return;
        }
        Subscription subscription = healthService.getHealthDetail(id)
                .compose(RxUtil.<HealthNewsDetail>rxSchedulerHelper())
                .subscribe(new Action1<HealthNewsDetail>() {
                    @Override
                    public void call(HealthNewsDetail healthNewsDetail) {
                        mView.showHealthNewsDetail(healthNewsDetail);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        mView.showError(App.getInstance().getString(R.string.msg_load_err));
                    }
                });
        addSubscribe(subscription);
    }

}
