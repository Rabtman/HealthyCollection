package com.rabt.healthycollection.ui.drug.view;

import com.rabt.healthycollection.base.BaseView;
import com.rabt.healthycollection.model.bean.DrugInfoDetail;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public interface DrugInfoDetailView extends BaseView {
    void showContent(DrugInfoDetail detail);
}
