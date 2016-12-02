package com.rabt.healthycollection.ui.drug.view;

import com.rabt.healthycollection.base.BaseView;
import com.rabt.healthycollection.model.bean.DrugInfoPage;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public interface DrugSearchResultView extends BaseView {
    void showContent(List<DrugInfoPage.DrugInfo> items);

    void showMoreContent(List<DrugInfoPage.DrugInfo> items, boolean hasMore);
}
