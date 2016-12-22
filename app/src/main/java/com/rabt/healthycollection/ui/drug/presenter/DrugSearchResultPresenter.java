package com.rabt.healthycollection.ui.drug.presenter;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.api.HealthService;
import com.rabt.healthycollection.base.App;
import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.ui.drug.view.DrugSearchResultView;
import com.rabt.healthycollection.utils.RxUtil;

import javax.inject.Inject;

import rx.Subscription;
import rx.functions.Action1;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public class DrugSearchResultPresenter extends RxPresenter<DrugSearchResultView> {

    private HealthService healthService;
    private int currentPage = 1;

    @Inject
    public DrugSearchResultPresenter(HealthService healthService) {
        this.healthService = healthService;
    }

    //查询药品
    public void getDrugList(String keyword) {
        currentPage = 1;
        Subscription subscription = healthService.searchDrugListInfo(keyword, currentPage)
                .compose(RxUtil.<DrugInfoPage>rxSchedulerHelper())
                .subscribe(new Action1<DrugInfoPage>() {
                               @Override
                               public void call(DrugInfoPage drugInfoPage) {
                                   mView.showContent(drugInfoPage.getDrugInfoList());
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
    public void getMoreDrugList(String keyword) {
        Subscription subscription = healthService.searchDrugListInfo(keyword, ++currentPage)
                .compose(RxUtil.<DrugInfoPage>rxSchedulerHelper())
                .subscribe(new Action1<DrugInfoPage>() {
                               @Override
                               public void call(DrugInfoPage drugInfoPage) {
                                   mView.showMoreContent(drugInfoPage.getDrugInfoList(),
                                           (drugInfoPage.getDrugInfoList() != null && drugInfoPage.getDrugInfoList().size() > 0));
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
