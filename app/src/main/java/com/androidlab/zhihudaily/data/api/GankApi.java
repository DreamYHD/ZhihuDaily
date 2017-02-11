package com.androidlab.zhihudaily.data.api;

import com.androidlab.zhihudaily.data.bean.MeizhiBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Haodong on 2017/1/23.
 */

public interface GankApi {
    /**
     * 获取妹子图片
     * @param count
     * @param page
     * @return
     */

    @GET("data/福利/{count}/{page}")
    Observable<MeizhiBean>  getGankMeizi(@Path("count") int count, @Path("page") int page);
}
