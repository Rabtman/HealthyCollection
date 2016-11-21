package com.rabt.healthycollection.api;

import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * author: Rabtman
 * date: 2016-11-06
 * description:
 */

public interface HealthApi {
    @GET("96-109")
    Observable<ShowApiResponse<HealthNewsPage>> getHealthList(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("showapi_res_gzip") int gzip, @Query("tid") int tid, @Query("keyword") String keyword, @Query("page") int page);

    @GET("96-36")
    Observable<ShowApiResponse<HealthNewsDetail>> getHealthDetail(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("showapi_res_gzip") int gzip, @Query("id") String id);
}
