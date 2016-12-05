package com.rabt.healthycollection.api;

import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.model.bean.HospitalPage;
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
    Observable<ShowApiResponse<HealthNewsPage>> getHealthList(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("tid") int tid, @Query("keyword") String keyword, @Query("page") int page);

    @GET("96-36")
    Observable<ShowApiResponse<HealthNewsDetail>> getHealthDetail(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("id") String id);

    @GET("93-97")
    Observable<ShowApiResponse<DrugInfoPage>> getDrugList(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("keyword") String keyword, @Query("manu") String manu, @Query("type") String type, @Query("page") int page);

    @GET("87-60")
    Observable<ShowApiResponse<HospitalPage>> getHospitalList(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("page") int page, @Query("hosName") String keyword, @Query("provinceName") String provinceName, @Query("cityName") String cityName);
}
