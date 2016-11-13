package com.rabt.healthycollection.base.http;

import com.rabt.healthycollection.BuildConfig;
import com.rabt.healthycollection.base.http.api.BWComicApi;
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

    private static OkHttpClient okHttpClient = null;
    private static BWComicApi bwComicService = null;

    public RetrofitManager() {
        initOkHttp();
        bwComicService = getBwComicService();
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    private void initOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
            builder.addInterceptor(loggingInterceptor);
        }
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        okHttpClient = builder.build();
    }

    private static BWComicApi getBwComicService() {
        return new Retrofit.Builder()
                .baseUrl(BWComicApi.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(BWComicApi.class);
    }

    public Observable<ShowApiResponse<BWComicPage>> getBWComicListInfo(String type, int page) {
        return bwComicService.getComicList(type, page);
    }
}
