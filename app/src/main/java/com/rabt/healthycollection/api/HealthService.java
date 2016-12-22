package com.rabt.healthycollection.api;

import com.rabt.healthycollection.base.http.RetrofitManager;
import com.rabt.healthycollection.model.bean.DrugInfoDetail;
import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.model.bean.HospitalPage;

import rx.Observable;

/**
 * @author zjm
 * @Description: 健康资讯服务
 * @date 2016/11/15
 */

public class HealthService {

    private static HealthApi healthService;

    public HealthService(RetrofitManager retrofitManager) {
        healthService = retrofitManager.getInstance().create(HealthApi.class);
    }

    public Observable<HealthNewsPage> getHealthListInfo(int id, int page) {
        return healthService.getHealthList(id, page);
    }

    public Observable<HealthNewsDetail> getHealthDetail(int id) {
        return healthService.getHealthDetail(id);
    }

    public Observable<DrugInfoPage> searchDrugListInfo(String keyword, int page) {
        return healthService.searchDrugs("drug", "name", keyword, page);
    }

    public Observable<DrugInfoDetail> getDrugInfoDetail(int id) {
        return healthService.getDrugDetail(id);
    }

    public Observable<HospitalPage> searchHospitalListInfo(String keyword, int page) {
        return healthService.searchHospitals("hospital", "name", keyword, page);
    }

    public Observable<HospitalPage> getHospitalList(int page, double latitude, double longitude) {
        return healthService.getHospitalList(page, latitude, longitude);
    }

    public Observable<HospitalPage.HospitalInfo> getHospitalInfoDetail(int id) {
        return healthService.getHospitalDetail(id);
    }
}
