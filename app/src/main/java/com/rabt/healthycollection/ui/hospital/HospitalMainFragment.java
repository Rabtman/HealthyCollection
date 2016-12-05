package com.rabt.healthycollection.ui.hospital;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.SimpleFragment;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.utils.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author zjm
 * @Description:
 * @date 2016/12/5
 */

public class HospitalMainFragment extends SimpleFragment {

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
    RecyclerView recyclerView;

    private String currentCity;

    @Override
    protected int getLayout() {
        return R.layout.fragment_hospital_main;
    }

    @Override
    protected void initData() {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }
}
