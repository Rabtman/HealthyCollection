package com.rabt.healthycollection.api;

import com.rabt.healthycollection.base.http.RetrofitManager;
import com.rabt.healthycollection.constant.BWComicConstant;
import com.rabt.healthycollection.model.bean.BWComicDetail;
import com.rabt.healthycollection.model.bean.BWComicPage;
import com.rabt.healthycollection.model.http.ShowApiResponse;

import rx.Observable;

/**
 * @author zjm
 * @Description: 黑白漫画服务
 * @date 2016/11/15
 */

public class BWComicService {

    private static BWComicApi bwComicService;

    public BWComicService(RetrofitManager retrofitManager) {
        bwComicService = retrofitManager.getInstance().create(BWComicApi.class);
    }

    public Observable<ShowApiResponse<BWComicPage>> getBWComicListInfo(String type, int page) {
        return bwComicService.getComicList(BWComicConstant.APP_ID, BWComicConstant.API_SIGN, type, page);
    }

    public Observable<ShowApiResponse<BWComicDetail>> getComicDetail(String id) {
        return bwComicService.getComicDetail(BWComicConstant.APP_ID, BWComicConstant.API_SIGN, id);
    }
}
