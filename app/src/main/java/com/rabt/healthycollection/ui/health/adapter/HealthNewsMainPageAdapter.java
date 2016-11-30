package com.rabt.healthycollection.ui.health.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.ui.health.factory.FragmentFactory;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/23
 */

public class HealthNewsMainPageAdapter extends FragmentPagerAdapter {

    public HealthNewsMainPageAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return FragmentFactory.createHealthNewsItemFragment(position);
    }

    @Override
    public int getCount() {
        return HealthConstants.HEALTH_TYPE.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return HealthConstants.HEALTH_TYPE.valueAt(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }
}
