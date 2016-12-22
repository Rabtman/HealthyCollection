package com.rabt.healthycollection.ui.hospital.view;

import com.rabt.healthycollection.base.BaseView;
import com.rabt.healthycollection.model.bean.HospitalPage;

/**
 * author: Rabtman
 * date: 2016-11-30
 * description:
 */

public interface HospitalInfoDetailView extends BaseView {
    void showContent(HospitalPage.HospitalInfo detail);
}
