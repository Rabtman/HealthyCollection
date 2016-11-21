package com.rabt.healthycollection.ui.bwcomic;

import android.content.Intent;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseFragment;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.ui.bwcomic.adapter.HealthNewsAdapter;
import com.rabt.healthycollection.ui.bwcomic.presenter.HealthNewsPresenter;
import com.rabt.healthycollection.ui.bwcomic.view.HealthNewsView;
import com.rabt.healthycollection.utils.SnackbarUtil;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public class HealthNewsFragment extends BaseFragment<HealthNewsPresenter> implements HealthNewsView {
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.view_progress)
    ContentLoadingProgressBar mProgress;

    private HealthNewsAdapter healthNewsAdapter;

    @Override
    protected void inject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_healthnews;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    protected void initData() {
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getHealthList();
            }
        });

        healthNewsAdapter = new HealthNewsAdapter(new ArrayList<HealthNewsPage.Page.Content>());
        healthNewsAdapter.openLoadAnimation();
        healthNewsAdapter.openLoadMore(20);
        healthNewsAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                KLog.d("getMoreHealthList");
                mPresenter.getMoreHealthList();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                KLog.d("SimpleOnItemChildClick");
                HealthNewsPage.Page.Content item = (HealthNewsPage.Page.Content) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getActivity(), HealthNewsDetailActivity.class);
                intent.putExtra(HealthConstants.HEALTHNEWS_ID, item.getId());
                getContext().startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(healthNewsAdapter);
        mProgress.setVisibility(View.VISIBLE);
        mPresenter.getHealthList();
    }

    private void stopProgressBar() {
        if (mSwipeLayout.isRefreshing()) {
            mSwipeLayout.setRefreshing(false);
        } else {
            mProgress.setVisibility(View.GONE);
        }
    }

    @Override
    public void showError(String msg) {
        stopProgressBar();
        SnackbarUtil.showShort(mRecyclerView, msg);
    }

    @Override
    public void showContent(List<HealthNewsPage.Page.Content> items) {
        stopProgressBar();
        healthNewsAdapter.setNewData(items);
    }

    @Override
    public void showMoreContent(List<HealthNewsPage.Page.Content> items, boolean hasMore) {
        healthNewsAdapter.addData(items);
        if (!hasMore) {
            healthNewsAdapter.loadComplete();
        }
    }
}
