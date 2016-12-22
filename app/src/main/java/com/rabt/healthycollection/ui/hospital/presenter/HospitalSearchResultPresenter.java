package com.rabt.healthycollection.ui.hospital.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.ui.hospital.view.HospitalSearchResultView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public class HospitalSearchResultPresenter extends RxPresenter<HospitalSearchResultView> {

    private HealthService healthService;
    private int currentPage = 1;

    @Inject
    public HospitalSearchResultPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    //查询药品
    public void getHospitalList(String keyword) {
        currentPage = 1;
        Subscription subscription = healthService.searchHospitalListInfo(keyword, currentPage)
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

    //查询更多药品
    public void getMoreHospitalList(String keyword) {
        Subscription subscription = healthService.searchHospitalListInfo(keyword, ++currentPage)
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
