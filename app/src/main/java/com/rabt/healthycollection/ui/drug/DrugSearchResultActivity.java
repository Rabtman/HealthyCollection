package com.rabt.healthycollection.ui.drug;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.ui.drug.presenter.DrugSearchResultPresenter;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description: 药品搜索结果列表
 */

public class DrugSearchResultActivity extends BaseActivity<DrugSearchResultPresenter> {
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Override
    protected void inject() {

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
