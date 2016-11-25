package com.rabt.healthycollection.ui.health;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.rabt.healthycollection.R;
import com.rabt.healthycollection.base.SimpleFragment;
import com.rabt.healthycollection.ui.health.adapter.HealthNewsMainPageAdapter;

import butterknife.BindView;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/23
 */

public class HealthNewsMainFragment extends SimpleFragment {
    @BindView(R.id.tab_health_main)
    TabLayout mTabLayout;
    @BindView(R.id.vp_health_main)
    ViewPager mViewPager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_healthnews_main;
    }

    @Override
    protected void initData() {
        HealthNewsMainPageAdapter adapter = new HealthNewsMainPageAdapter(getFragmentManager());
        mViewPager.setAdapter(adapter);
        mViewPager.setOffscreenPageLimit(1);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
