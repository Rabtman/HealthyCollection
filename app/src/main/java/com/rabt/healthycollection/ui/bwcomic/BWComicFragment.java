package com.rabt.healthycollection.ui.bwcomic;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.orhanobut.logger.Logger;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseFragment;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.ui.bwcomic.adapter.BWComicAdapter;
import com.rabt.healthycollection.ui.bwcomic.presenter.BWComicPresenter;
import com.rabt.healthycollection.ui.bwcomic.view.BWComicView;
import com.rabt.healthycollection.utils.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public class BWComicFragment extends BaseFragment<BWComicPresenter> implements BWComicView {
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.view_progress)
    ContentLoadingProgressBar mProgress;

    private BWComicAdapter bwComicAdapter;
    private List<BWComicPage.Page.ComicItem> mList = new ArrayList<>();

    @Override
    protected void inject() {
        getFragmentComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_bwcomic;
    }

    @Override
    protected void initData() {
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getBWComicList();
            }
        });

        bwComicAdapter = new BWComicAdapter(mList);
        bwComicAdapter.openLoadAnimation();
        bwComicAdapter.openLoadMore(50);
        bwComicAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Logger.d("getMoreBWComicList");
                mPresenter.getMoreBWComicList();
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }
        });
        mRecyclerView.setAdapter(bwComicAdapter);
        mProgress.setVisibility(View.VISIBLE);
        mPresenter.getBWComicList();
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
    public void showContent(List<BWComicPage.Page.ComicItem> items) {
        stopProgressBar();
        mList.clear();
        mList.addAll(items);
        bwComicAdapter.notifyDataSetChanged();
    }

    @Override
    public void showMoreContent(List<BWComicPage.Page.ComicItem> items, boolean hasMore) {
        bwComicAdapter.addData(items);
        if (!hasMore) {
            bwComicAdapter.loadComplete();
        }
    }
}
