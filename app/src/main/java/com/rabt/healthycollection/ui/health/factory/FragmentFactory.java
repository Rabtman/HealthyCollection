package com.rabt.healthycollection.ui.health.factory;

import android.os.Bundle;

import com.rabt.healthycollection.constant.HealthConstants;
import com.rabt.healthycollection.ui.health.HealthNewsItemFragment;

import java.util.HashMap;
import java.util.Map;

import me.yokeyword.fragmentation.SupportFragment;

import static com.rabt.healthycollection.constant.HealthConstants.HEALTHNEWS_ID;

/**
 * @author zjm
 * @Description: fragment缓存工厂
 * @date 2016/11/23
 */

public class FragmentFactory {
    private static Map<String, SupportFragment> mCache = new HashMap<>();

    //健康资讯fragment
    public static SupportFragment createHealthNewsItemFragment(int pos) {
        SupportFragment supportFragment = mCache.get(HealthConstants.HEALTH_TYPE.valueAt(pos));
        if (supportFragment == null) {
            supportFragment = new HealthNewsItemFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(HEALTHNEWS_ID, HealthConstants.HEALTH_TYPE.keyAt(pos));
            supportFragment.setArguments(bundle);
            mCache.put(HealthConstants.HEALTH_TYPE.valueAt(pos), supportFragment);
        }
        return supportFragment;
    }
}
