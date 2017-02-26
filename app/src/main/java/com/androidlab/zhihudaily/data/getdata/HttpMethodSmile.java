package com.androidlab.zhihudaily.data.getdata;

import com.androidlab.zhihudaily.data.api.SmileApi;
import com.androidlab.zhihudaily.data.bean.SmileBean;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Haodong on 2017/2/24.
 */

public class HttpMethodSmile extends BaseHttpData{

    private Retrofit mRetrofit;

    private SmileApi mSmileApi;

    public static final  String key="0aebd5cd60774fc1821acf865e466040";



    private HttpMethodSmile(){
        OkHttpClient.Builder  builder=new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT_CONNECT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT_WRITE,TimeUnit.SECONDS);
        builder.readTimeout(DEFAULT_TIMEOUT_READ,TimeUnit.SECONDS);

        mRetrofit=new Retrofit.Builder()
                .baseUrl(Base_Smile_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        mSmileApi=mRetrofit.create(SmileApi.class);



    }
    private static class SingleHolder{

        private static final HttpMethodSmile INSTANCE=new HttpMethodSmile();
    }
    public static HttpMethodSmile getInstance(){
        return SingleHolder.INSTANCE;
    }

    public  void getSmile(Subscriber<SmileBean>subscriber, int pagesize, int page){
        mSmileApi.getSmile(pagesize,page,key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }




}
