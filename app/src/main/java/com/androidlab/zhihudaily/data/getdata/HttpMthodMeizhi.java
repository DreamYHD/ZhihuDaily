package com.androidlab.zhihudaily.data.getdata;

import com.androidlab.zhihudaily.data.api.GankApi;
import com.androidlab.zhihudaily.data.bean.MeizhiBean;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 封装wan
 * Created by Haodong on 2017/2/6.
 */

public class HttpMthodMeizhi extends BaseHttpData {

    private Retrofit mRetrofit;

    private GankApi mGankApi;

    private HttpMthodMeizhi() {



        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT_CONNECT, TimeUnit.SECONDS);
        httpClientBuilder.writeTimeout(DEFAULT_TIMEOUT_WRITE, TimeUnit.SECONDS);
        httpClientBuilder.readTimeout(DEFAULT_TIMEOUT_READ, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(Base_Meizhi_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        mGankApi = mRetrofit.create(GankApi.class);

    }

    private static class SingletoHolder {

        private static final HttpMthodMeizhi INSTANCE = new HttpMthodMeizhi();
    }

    public static HttpMthodMeizhi getInstance() {

        return SingletoHolder.INSTANCE;
    }

    public void getGankMeizi(Subscriber<MeizhiBean> subscriber, int start, int count) {
        mGankApi.getGankMeizi(start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}
