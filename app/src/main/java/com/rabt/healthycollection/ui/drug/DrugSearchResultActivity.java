package com.rabt.healthycollection.ui.drug;

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
import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.ui.drug.adpater.DrugSearchResultAdapter;
import com.rabt.healthycollection.ui.drug.presenter.DrugSearchResultPresenter;
import com.rabt.healthycollection.ui.drug.view.DrugSearchResultView;
import com.rabt.healthycollection.utils.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description: 药品搜索结果列表
 */

public class DrugSearchResultActivity extends BaseActivity<DrugSearchResultPresenter> implements DrugSearchResultView {
    @BindView(R.id.toolbar)
    Toolbar mToolBar;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private String drugKeyWord;
    private String drugTypeId;
    private DrugSearchResultAdapter drugSearchResultAdapter;

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
        drugKeyWord = getIntent().getStringExtra(HealthConstants.DRUG_KEYWORD);
        drugTypeId = getIntent().getStringExtra(HealthConstants.DRUG_TYPE_ID);

        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getDrugList(drugKeyWord, drugTypeId, "");
            }
        });

        drugSearchResultAdapter = new DrugSearchResultAdapter(new ArrayList<DrugInfoPage.DrugInfo>());
        drugSearchResultAdapter.openLoadAnimation();
        drugSearchResultAdapter.openLoadMore(20);
        drugSearchResultAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreDrugList(drugKeyWord, drugTypeId, "");
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                DrugInfoPage.DrugInfo item = (DrugInfoPage.DrugInfo) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getBaseContext(), DrugInfoDetailActivity.class);
                intent.putExtra(HealthConstants.DRUG_INFO, item);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(drugSearchResultAdapter);
        showProgress();
        mPresenter.getDrugList(drugKeyWord, drugTypeId, "");
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
    public void showContent(List<DrugInfoPage.DrugInfo> items) {
        if (mSwipeLayout != null && mSwipeLayout.isRefreshing()) {
            mSwipeLayout.setRefreshing(false);
        }
        stopProgress();
        drugSearchResultAdapter.setNewData(items);
    }

    @Override
    public void showMoreContent(List<DrugInfoPage.DrugInfo> items, boolean hasMore) {
        drugSearchResultAdapter.addData(items);
        if (!hasMore) {
            drugSearchResultAdapter.loadComplete();
        }
    }
}
