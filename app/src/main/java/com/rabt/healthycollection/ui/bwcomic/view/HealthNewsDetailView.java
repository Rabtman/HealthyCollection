package com.rabt.healthycollection.ui.bwcomic.view;

import com.rabt.healthycollection.base.BaseView;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description:
 */

public interface HealthNewsDetailView extends BaseView {
    void showComicDetail(HealthNewsDetail.Info healthNewsDetail);
}
