package com.rabt.healthycollection.ui.bwcomic.presenter;

import com.rabt.healthycollection.base.RxPresenter;
import com.rabt.healthycollection.base.http.RetrofitManager;
import com.rabt.healthycollection.ui.bwcomic.view.BWComicDetailView;

import javax.inject.Inject;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/14
 */

public class BWComicDetailPresenter extends RxPresenter<BWComicDetailView> {

    private RetrofitManager mRetrofitManager;

    @Inject
    public BWComicDetailPresenter(RetrofitManager retrofitManager) {
        mRetrofitManager = retrofitManager;
    }


}
