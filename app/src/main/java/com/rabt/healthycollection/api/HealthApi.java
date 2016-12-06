package com.rabt.healthycollection.api;

import com.rabt.healthycollection.model.bean.DrugInfoDetail;
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
    @GET("info/list")
    Observable<HealthNewsPage> getHealthList(@Query("id") int id, @Query("page") int page);

    @GET("info/show")
    Observable<HealthNewsDetail> getHealthDetail(@Query("id") int id);

    @GET("search")
    Observable<DrugInfoPage> getDrugList(@Query("name") String name, @Query("type") String type, @Query("keyword") String keyword, @Query("page") int page);

    @GET("drug/show")
    Observable<DrugInfoDetail> getDrugDetail(@Query("id") int id);

    @GET("87-60")
    Observable<ShowApiResponse<HospitalPage>> getHospitalList(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("page") int page, @Query("hosName") String keyword, @Query("provinceName") String provinceName, @Query("cityName") String cityName);
}
