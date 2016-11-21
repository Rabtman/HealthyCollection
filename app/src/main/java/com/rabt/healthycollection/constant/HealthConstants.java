package com.rabt.healthycollection.constant;

import android.util.SparseArray;

/**
 * @author zjm
 * @Description:
 * @date 2016/11/21
 */

public class HealthConstants {
    public static final String HEALTHNEWS_ID = "healthnews_id";
    public static SparseArray<String> TYPE;

    static {
        TYPE = new SparseArray<>();
        TYPE.put(1, "企业要闻");
        TYPE.put(2, "医药新闻");
        TYPE.put(3, "生活贴士");
        TYPE.put(4, "药品新闻");
        TYPE.put(5, "食品新闻");
        TYPE.put(6, "社会热点");
    }
}
