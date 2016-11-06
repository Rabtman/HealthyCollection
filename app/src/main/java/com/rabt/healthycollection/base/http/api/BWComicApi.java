package com.rabt.healthycollection.base.http.api;

import com.rabt.healthycollection.model.bean.BWComicDetail;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


/**
 * author: Rabtman
 * date: 2016-11-06
 * description: 黑白漫画api
 */

public interface BWComicApi {

    String BASE_URL = "http://route.showapi.com/";
    String APP_ID = "26744";
    String API_SIGN = "dd81d3c7bddb4b73bf09f69a1d015d8d";

    @GET("958-1?showapi_appid=" + APP_ID + "&showapi_sign=" + API_SIGN + "&type={type}&page={page}")
    Observable<ShowApiResponse<BWComicPage>> getComicList(@Path("type") String type, @Path("page") int page);

    @GET("958-2?showapi_appid=" + APP_ID + "&showapi_sign=" + API_SIGN + "&id={id}")
    Observable<ShowApiResponse<BWComicDetail>> getComicDetail(@Path("id") String id);
}
