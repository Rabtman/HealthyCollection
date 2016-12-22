package com.rabt.healthycollection.ui.hospital.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.ui.hospital.view.HospitalInfoDetailView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public class HospitalInfoDetailPresenter extends RxPresenter<HospitalInfoDetailView> {

    private HealthService healthService;

    @Inject
    public HospitalInfoDetailPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    //药品详情
    public void showHospitalInfoDetail(int id) {
        Subscription subscription = healthService.getHospitalInfoDetail(id)
                .compose(RxUtil.<HospitalPage.HospitalInfo>rxSchedulerHelper())
                .subscribe(new Action1<HospitalPage.HospitalInfo>() {
                               @Override
                               public void call(HospitalPage.HospitalInfo drugInfoDetail) {
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
