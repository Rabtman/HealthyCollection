package com.rabt.healthycollection.base.http.api;

import com.rabt.healthycollection.model.bean.BWComicDetail;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


/**
 * author: Rabtman
 * date: 2016-11-06
 * description: 黑白漫画api
 */

public interface BWComicApi {
    @GET("958-1")
    Observable<ShowApiResponse<BWComicPage>> getComicList(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("type") String type, @Query("page") int page);

    @GET("958-2")
    Observable<ShowApiResponse<BWComicDetail>> getComicDetail(@Query("showapi_appid") String appId, @Query("showapi_sign") String apiSign, @Query("id") String id);
}
