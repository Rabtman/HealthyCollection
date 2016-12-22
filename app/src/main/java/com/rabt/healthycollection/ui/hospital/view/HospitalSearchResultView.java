package com.rabt.healthycollection.ui.hospital.view;

import com.rabt.healthycollection.base.BaseView;
import com.rabt.healthycollection.model.bean.HospitalPage;

import java.util.List;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public interface HospitalSearchResultView extends BaseView {
    void showContent(List<HospitalPage.HospitalInfo> items);

    void showMoreContent(List<HospitalPage.HospitalInfo> items, boolean hasMore);
}
