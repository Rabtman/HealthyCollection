package com.rabt.healthycollection.ui.hospital;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseFragment;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.ui.hospital.adapter.HospitalSearchResultAdapter;
import com.rabt.healthycollection.ui.hospital.presenter.HospitalMainPresenter;
import com.rabt.healthycollection.ui.hospital.view.HospitalMainView;
import com.rabt.healthycollection.utils.SnackbarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author zjm
 * @Description:
 * @date 2016/12/5
 */

public class HospitalMainFragment extends BaseFragment<HospitalMainPresenter> implements HospitalMainView {


    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeLayout;

    private HospitalSearchResultAdapter adapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_hospital_main;
    }

    @Override
    protected void initData() {
        mSwipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.getHospitalList();
            }
        });

        adapter = new HospitalSearchResultAdapter(new ArrayList<HospitalPage.HospitalInfo>());
        adapter.openLoadAnimation();
        adapter.openLoadMore(20);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreHospitalList();
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HospitalPage.HospitalInfo item = (HospitalPage.HospitalInfo) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getContext(), HospitalInfoDetailActivity.class);
                intent.putExtra(HealthConstants.HOSPITAL_ID, item.getId());
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
        showProgress();
        mPresenter.getHospitalList();
    }

    @Override
    protected void inject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showContent(List<HospitalPage.HospitalInfo> items) {
        if (mSwipeLayout != null && mSwipeLayout.isRefreshing()) {
            mSwipeLayout.setRefreshing(false);
        }
        stopProgress();
        adapter.setNewData(items);
    }

    @Override
    public void showMoreContent(List<HospitalPage.HospitalInfo> items, boolean hasMore) {
        adapter.addData(items);
        if (!hasMore) {
            adapter.loadComplete();
        }
    }

    @Override
    public void showError(String msg) {
        if (mSwipeLayout != null && mSwipeLayout.isRefreshing()) {
            mSwipeLayout.setRefreshing(false);
        }
        stopProgress();
        SnackbarUtil.showShort(mRecyclerView, msg);
    }

}
