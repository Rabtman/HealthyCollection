package com.rabt.healthycollection.ui.hospital;

import android.content.Intent;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.orhanobut.logger.Logger;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.BaseFragment;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.ui.hospital.adapter.HospitalSearchResultAdapter;
import com.rabt.healthycollection.ui.hospital.presenter.HospitalMainPresenter;
import com.rabt.healthycollection.ui.hospital.view.HospitalMainView;
import com.rabt.healthycollection.utils.SnackbarUtil;
import com.rabt.healthycollection.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author zjm
 * @Description:
 * @date 2016/12/5
 */

public class HospitalMainFragment extends BaseFragment<HospitalMainPresenter> implements HospitalMainView {

    @BindView(R.id.hospital_city)
    TextView hospitalCity;
    @BindView(R.id.hospital_search)
    AppCompatImageButton hospitalSearch;
    @BindView(R.id.hospital_close)
    AppCompatImageButton hospitalClose;
    @BindView(R.id.hospital_keyword)
    AppCompatEditText hospitalKeyword;
    @BindView(R.id.title_result)
    TextView titleResult;
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    private HospitalSearchResultAdapter adapter;
    private String currentCity;

    @Override
    protected int getLayout() {
        return R.layout.fragment_hospital_main;
    }

    @Override
    protected void initData() {
        adapter = new HospitalSearchResultAdapter(new ArrayList<HospitalPage.HospitalInfo>());
        adapter.openLoadAnimation();
        adapter.openLoadMore(20);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                mPresenter.getMoreHospitalList(hospitalKeyword.getText().toString(), currentCity);
            }
        });
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                HospitalPage.HospitalInfo item = (HospitalPage.HospitalInfo) baseQuickAdapter.getItem(i);
                Intent intent = new Intent(getContext(), HospitalInfoDetailActivity.class);
                intent.putExtra(HealthConstants.HOSPITAL_INFO, item);
                startActivity(intent);
            }
        });
        mRecyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.hospital_search)
    void search() {
        showProgress();
        mPresenter.getHospitalList(hospitalKeyword.getText().toString(), currentCity);
    }

    @OnClick(R.id.hospital_city)
    void select() {
        Intent intent = new Intent(getContext(), PickCityActivity.class);
        startActivityForResult(intent, HealthConstants.CODE_SELECT_CITY);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Logger.d("requestCode:" + requestCode + "|resultCode:" + resultCode);
        switch (resultCode) {
            case HealthConstants.CODE_SELECT_CITY:
                if (data == null) break;
                String city = data.getStringExtra(HealthConstants.HOSPITAL_CITY);
                if (StringUtils.isEmpty(city)) break;
                //更改当前选中的城市
                currentCity = city;
                //切换显示的城市
                if (city.length() > 3) {
                    hospitalCity.setText(city.substring(0, 3));
                    hospitalCity.append("..");
                } else {
                    hospitalCity.setText(city);
                }
                break;
        }
    }

    @Override
    protected void inject() {
        getFragmentComponent().inject(this);
    }

    @Override
    public void showContent(List<HospitalPage.HospitalInfo> items) {
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
        stopProgress();
        SnackbarUtil.showShort(mRecyclerView, msg);
    }
}
