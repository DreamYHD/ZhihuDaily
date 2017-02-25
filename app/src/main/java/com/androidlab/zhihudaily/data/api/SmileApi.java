package com.androidlab.zhihudaily.data.api;

import com.androidlab.zhihudaily.data.bean.SmileBean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Haodong on 2017/2/24.
 */

public interface SmileApi {
    @GET("ContentList")
    Observable<SmileBean>getSmile(@Query("pagesize")int pagesize,
                                  @Query("page")int page,
                                  @Query("key")String key);

}
