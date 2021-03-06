package com.rabt.healthycollection.ui.hospital.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.ui.hospital.view.HospitalMainView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public class HospitalMainPresenter extends RxPresenter<HospitalMainView> {

    private HealthService healthService;
    private int currentPage = 1;

    @Inject
    public HospitalMainPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    //查询医院信息
    public void getHospitalList() {
        currentPage = 1;
        Subscription subscription = healthService.getHospitalList(currentPage, 39.90, 116.405)
                .compose(RxUtil.<HospitalPage>rxSchedulerHelper())
                .subscribe(new Action1<HospitalPage>() {
                               @Override
                               public void call(HospitalPage hospitalPage) {
                                   mView.showContent(hospitalPage.getHospitalList());
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

    //查询更多医院信息
    public void getMoreHospitalList() {
        Subscription subscription = healthService.getHospitalList(++currentPage, 39.90, 116.405)
                .compose(RxUtil.<HospitalPage>rxSchedulerHelper())
                .subscribe(new Action1<HospitalPage>() {
                               @Override
                               public void call(HospitalPage hospitalPage) {
                                   mView.showMoreContent(hospitalPage.getHospitalList(),
                                           (hospitalPage.getHospitalList() != null && hospitalPage.getHospitalList().size() > 0));
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                --currentPage;
                                mView.showError(App.getInstance().getString(R.string.msg_load_err));
                            }
                        });
        addSubscribe(subscription);
    }
}
