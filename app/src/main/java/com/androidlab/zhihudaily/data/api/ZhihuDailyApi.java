package com.androidlab.zhihudaily.data.api;

import com.androidlab.zhihudaily.data.bean.NewsBean;
import com.androidlab.zhihudaily.data.bean.NewsContentBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Haodong on 2017/1/23.
 */

public interface ZhihuDailyApi {

    /**
     * 获取列表
     *
     * @return
     */

    @GET("news/latest")
    Observable<NewsBean> getNewLatest();
    /**
     * 获取内容
     *
     * @param id 根据内容获取
     * @return
     */
    @GET("news/{id}")
    Observable<NewsContentBean> getNewsContent(@Path("id") int id);

}
