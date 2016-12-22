package com.rabt.healthycollection.api;

import com.rabt.healthycollection.model.bean.DrugInfoDetail;
import com.rabt.healthycollection.model.bean.DrugInfoPage;
import com.rabt.healthycollection.model.bean.HealthNewsDetail;
import com.rabt.healthycollection.model.bean.HealthNewsPage;
import com.rabt.healthycollection.model.bean.HospitalPage;

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
    Observable<DrugInfoPage> searchDrugs(@Query("name") String name, @Query("type") String type, @Query("keyword") String keyword, @Query("page") int page);

    @GET("drug/show")
    Observable<DrugInfoDetail> getDrugDetail(@Query("id") int id);

    @GET("hospital/location")
    Observable<HospitalPage> getHospitalList(@Query("page") int page, @Query("y") double latitude, @Query("x") double longitude);

    @GET("search")
    Observable<HospitalPage> searchHospitals(@Query("name") String name, @Query("type") String type, @Query("keyword") String keyword, @Query("page") int page);

    @GET("hospital/show")
    Observable<HospitalPage.HospitalInfo> getHospitalDetail(@Query("id") int id);
}
