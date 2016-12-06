package com.rabt.healthycollection.api;

import com.rabt.healthycollection.BuildConfig;
import com.rabt.healthycollection.base.http.RetrofitManager;
import com.rabt.healthycollection.model.bean.DrugInfoDetail;
import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.model.bean.HospitalPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;

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

    public Observable<DrugInfoPage> getDrugListInfo(String keyword, int page) {
        return healthService.getDrugList("drug", "name", keyword, page);
    }

    public Observable<DrugInfoDetail> getDrugInfoDetail(int id) {
        return healthService.getDrugDetail(id);
    }

    public Observable<ShowApiResponse<HospitalPage>> getHospitalList(int page, String keyword, String provinceName, String cityName) {
        return healthService.getHospitalList(BuildConfig.APP_ID, BuildConfig.API_SIGN, page, keyword, provinceName, cityName);
    }
}
