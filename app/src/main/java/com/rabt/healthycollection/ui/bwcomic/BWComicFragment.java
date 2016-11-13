package com.rabt.healthycollection.ui.bwcomic;

import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseFragment;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.ui.bwcomic.adapter.BWComicAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public class BWComicFragment extends BaseFragment<BWComicPresenter> implements BWComicContract.View {
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.view_progress)
    ContentLoadingProgressBar progressBar;

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

            }
        });

        bwComicAdapter = new BWComicAdapter(mList);
        bwComicAdapter.openLoadAnimation();
        bwComicAdapter.openLoadMore(50);
        bwComicAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void SimpleOnItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }
        });
        mRecyclerView.setAdapter(bwComicAdapter);
    }

    @Override
    public void showError(String msg) {

    }
}
