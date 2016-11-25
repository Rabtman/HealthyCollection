package com.rabt.healthycollection.ui.health.view;

import com.rabt.healthycollection.base.BaseView;
import com.rabt.healthycollection.model.bean.HealthNewsPage;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description:
 */

public interface HealthNewsView extends BaseView {
    void showContent(List<HealthNewsPage.Page.Content> items);

    void showMoreContent(List<HealthNewsPage.Page.Content> items, boolean hasMore);
}
