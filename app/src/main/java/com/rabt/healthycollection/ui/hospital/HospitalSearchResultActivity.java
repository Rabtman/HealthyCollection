package com.rabt.healthycollection.ui.hospital;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.ui.hospital.adapter.HospitalSearchResultAdapter;
import com.rabt.healthycollection.ui.hospital.presenter.HospitalSearchResultPresenter;
import com.rabt.healthycollection.ui.hospital.view.HospitalSearchResultView;
import com.rabt.healthycollection.utils.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description: 医院搜索结果列表
 */

public class HospitalSearchResultActivity extends BaseActivity<HospitalSearchResultPresenter> implements HospitalSearchResultView {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private String hospitalKeyWord;

    private HospitalSearchResultAdapter hospitalSearchResultAdapter;

    @Override
    protected void inject() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_drug_search_results;
    }

    @Override
    protected void initData() {
        setToolBar(mToolBar, getString(R.string.title_search_result));
        //获取传递的参数
        hospitalKeyWord = getIntent().getStringExtra(HealthConstants.HOSPITAL_KEYWORD);

        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getHospitalList(hospitalKeyWord);
            }
        });

        hospitalSearchResultAdapter = new HospitalSearchResultAdapter(new ArrayList<HospitalPage.HospitalInfo>());
        hospitalSearchResultAdapter.openLoadAnimation();
        hospitalSearchResultAdapter.openLoadMore(20);
        hospitalSearchResultAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreHospitalList(hospitalKeyWord);
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HospitalPage.HospitalInfo item = (HospitalPage.HospitalInfo) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getBaseContext(), HospitalInfoDetailActivity.class);
                intent.putExtra(HealthConstants.HOSPITAL_INFO, item);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(hospitalSearchResultAdapter);
        showProgress();
        mPresenter.getHospitalList(hospitalKeyWord);
    }

    @Override
    public void showError(String msg) {
        if (mSwipeLayout != null && mSwipeLayout.isRefreshing()) {
            mSwipeLayout.setRefreshing(false);
        }
        stopProgress();
        SnackbarUtil.showShort(mRecyclerView, msg);
    }

    @Override
    public void showContent(List<HospitalPage.HospitalInfo> items) {
        if (mSwipeLayout != null && mSwipeLayout.isRefreshing()) {
            mSwipeLayout.setRefreshing(false);
        }
        stopProgress();
        hospitalSearchResultAdapter.setNewData(items);
    }

    @Override
    public void showMoreContent(List<HospitalPage.HospitalInfo> items, boolean hasMore) {
        hospitalSearchResultAdapter.addData(items);
        if (!hasMore) {
            hospitalSearchResultAdapter.loadComplete();
        }
    }
}
