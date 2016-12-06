package com.rabt.healthycollection.ui.drug.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.DrugInfoDetail;
import com.rabt.healthycollection.ui.drug.view.DrugInfoDetailView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public class DrugInfoDetailPresenter extends RxPresenter<DrugInfoDetailView> {

    private HealthService healthService;
    private int currentPage = 1;

    @Inject
    public DrugInfoDetailPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    //药品详情
    public void showDrugInfoDetail(int id) {
        Subscription subscription = healthService.getDrugInfoDetail(id)
                .compose(RxUtil.<DrugInfoDetail>rxSchedulerHelper())
                .subscribe(new Action1<DrugInfoDetail>() {
                               @Override
                               public void call(DrugInfoDetail drugInfoDetail) {
                                   mView.showContent(drugInfoDetail);
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                mView.showError(App.getInstance().getString(R.string.msg_load_err));
                            }
                        });
        addSubscribe(subscription);
    }
}
