package com.androidlab.zhihudaily.data.api;

import com.androidlab.zhihudaily.data.bean.NewsBean;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Haodong on 2017/1/23.
 */

public interface ZhihuDailyApi {

    @GET("news/latest")
    Observable<NewsBean> getNewLatest();

}
