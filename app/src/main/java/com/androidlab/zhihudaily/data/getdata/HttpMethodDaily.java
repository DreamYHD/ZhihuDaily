package com.androidlab.zhihudaily.data.getdata;

import com.androidlab.zhihudaily.data.api.GankApi;
import com.androidlab.zhihudaily.data.api.ZhihuDailyApi;
import com.androidlab.zhihudaily.data.bean.NewsBean;
import com.androidlab.zhihudaily.data.bean.NewsContentBean;
import com.androidlab.zhihudaily.utils.ShowToast;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Haodong on 2017/2/6.
 */

public class HttpMethodDaily extends BaseHttpData {

    private Retrofit mRetrofit;

    private ZhihuDailyApi mZhihuDailyApi;


    public HttpMethodDaily() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT_CONNECT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT_WRITE, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT_READ, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(Base_Daily_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mZhihuDailyApi = mRetrofit.create(ZhihuDailyApi.class);


    }

    private static class SingletoHolder {
        private static final HttpMethodDaily INSTANCE = new HttpMethodDaily();
    }

    public static HttpMethodDaily getInstance() {
        return SingletoHolder.INSTANCE;
    }

    public void getNewLatest(Subscriber<NewsBean> subscriber) {
        mZhihuDailyApi.getNewLatest()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);

    }

    public void getNewContent(Subscriber<NewsContentBean> subscriber, int id) {
        mZhihuDailyApi.getNewsContent(id)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);


    }


}
