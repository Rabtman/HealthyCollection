package com.rabt.healthycollection.api;

import com.rabt.healthycollection.BuildConfig;
import com.rabt.healthycollection.base.http.RetrofitManager;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
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

    public Observable<ShowApiResponse<HealthNewsPage>> getHealthListInfo(int tid, String keyword, int page) {
        return healthService.getHealthList(BuildConfig.APP_ID, BuildConfig.API_SIGN, 1, tid, keyword, page);
    }

    public Observable<ShowApiResponse<HealthNewsDetail>> getHealthDetail(String id) {
        return healthService.getHealthDetail(BuildConfig.APP_ID, BuildConfig.API_SIGN, 1, id);
    }
}
