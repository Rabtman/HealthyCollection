package com.rabt.healthycollection.base.http;

import com.rabt.healthycollection.BuildConfig;
import com.rabt.healthycollection.base.http.api.BWComicApi;
import com.rabt.healthycollection.constant.BWComicConstant;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * author: Rabtman
 * date: 2016-11-13
 * description: retrofit管理
 */

public class RetrofitManager {

    private static Retrofit retrofit = null;
    private static OkHttpClient okHttpClient = null;
    private static BWComicApi bwComicService = null;

    public RetrofitManager() {
        initOkHttp();
        initRetrofit();
        bwComicService = retrofit.create(BWComicApi.class);
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        //设置超时
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(40, TimeUnit.SECONDS);
        builder.writeTimeout(40, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    private void initRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BWComicConstant.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    public Observable<ShowApiResponse<BWComicPage>> getBWComicListInfo(String type, int page) {
        return bwComicService.getComicList(BWComicConstant.APP_ID, BWComicConstant.API_SIGN, type, page);
    }
}
