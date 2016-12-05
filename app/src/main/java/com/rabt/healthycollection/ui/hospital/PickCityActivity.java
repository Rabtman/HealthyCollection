package com.rabt.healthycollection.ui.hospital;

import android.content.Intent;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.orhanobut.logger.Logger;
import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.SimpleActivity;
import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.model.bean.City;
import com.rabt.healthycollection.ui.hospital.adapter.CityAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableLayout;

/**
 * @author zjm
 * @Description: 城市选择界面
 * @date 2016/12/5
 */

public class PickCityActivity extends SimpleActivity {
    @BindView(R.id.toolbar)
    Toolbar toolBar;
    @BindView(R.id.index_layout)
    IndexableLayout indexLayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_pick_cities;
    }

    @Override
    protected void initData() {
        setToolBar(toolBar, getString(R.string.title_select_city));
        CityAdapter adapter = new CityAdapter(this);
        indexLayout.setAdapter(adapter);
        adapter.setDatas(initCities(), new IndexableAdapter.IndexCallback<City>() {
            @Override
            public void onFinished(List<City> datas) {
                Logger.d("城市列表加载完毕:" + datas.size());
            }
        });

        adapter.setOnItemContentClickListener(new IndexableAdapter.OnItemContentClickListener<City>() {
            @Override
            public void onItemClick(View v, int originalPosition, int currentPosition, City entity) {
                Logger.d("originalPosition:" + originalPosition + "|currentPosition:" + currentPosition);
                Logger.d("City:" + entity.toString());
                Intent result = new Intent();
                result.putExtra(HealthConstants.HOSPITAL_CITY, entity.getName().substring(0, entity.getName().length() - 1));
                setResult(HealthConstants.CODE_SELECT_CITY, result);
                finish();
            }
        });
    }

    private List<City> initCities() {
        List<City> list = new ArrayList<>();
        List<String> cityStrings = Arrays.asList(getResources().getStringArray(R.array.city_array));
        for (String item : cityStrings) {
            City city = new City();
            city.setName(item);
            list.add(city);
        }
        return list;
    }
}
