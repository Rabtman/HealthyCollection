package com.rabt.healthycollection.utils;

import android.text.TextUtils;

import com.rabt.healthycollection.base.http.exception.ApiException;
import com.rabt.healthycollection.model.http.ShowApiResponse;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;


public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> observable) {
                return observable.subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    /**
     * showApi统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T> Observable.Transformer<ShowApiResponse<T>, T> handleShowApiResult() {   //compose判断结果
        return new Observable.Transformer<ShowApiResponse<T>, T>() {
            @Override
            public Observable<T> call(Observable<ShowApiResponse<T>> httpResponseObservable) {
                return httpResponseObservable.flatMap(new Func1<ShowApiResponse<T>, Observable<T>>() {
                    @Override
                    public Observable<T> call(ShowApiResponse<T> showApiResponse) {
                        if (showApiResponse.getCode() == 0) {
                            return createData(showApiResponse.getBody());
                        } else if (!TextUtils.isEmpty(showApiResponse.getError())) {
                            return Observable.error(new ApiException(showApiResponse.getError()));
                        } else {
                            return Observable.error(new ApiException("服务器返回error"));
                        }
                    }
                });
            }
        };
    }

    /**
     * 生成Observable
     *
     * @param <T>
     * @return
     */
    public static <T> Observable<T> createData(final T t) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(t);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}
