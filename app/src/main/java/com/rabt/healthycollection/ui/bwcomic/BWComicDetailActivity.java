package com.rabt.healthycollection.ui.bwcomic;

import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.ui.bwcomic.presenter.BWComicDetailPresenter;
import com.rabt.healthycollection.ui.bwcomic.view.BWComicDetailView;

/**
 * @author zjm
 * @Description: 黑白漫画详情
 * @date 2016/11/14
 */

public class BWComicDetailActivity extends BaseActivity<BWComicDetailPresenter> implements BWComicDetailView {
    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showError(String msg) {

    }
}
