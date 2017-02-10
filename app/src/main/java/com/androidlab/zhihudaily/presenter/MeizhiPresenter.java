package com.androidlab.zhihudaily.presenter;

import android.support.annotation.NonNull;

import com.androidlab.zhihudaily.contract.MeiziImageContract;
import com.androidlab.zhihudaily.data.bean.MeizhiBean;
import com.androidlab.zhihudaily.data.getdata.HttpMthodMeizhi;
import com.androidlab.zhihudaily.utils.Logger;

import java.util.Random;

import rx.Subscriber;

/**
 * Created by Haodong on 2017/1/22.
 */

public class MeizhiPresenter implements MeiziImageContract.Presenter {

    private final MeiziImageContract.View mView;

    private HttpMthodMeizhi mHttpMthodMeizhi;

    private Subscriber subscriber;


    public MeizhiPresenter(MeiziImageContract.View view) {

        mHttpMthodMeizhi = HttpMthodMeizhi.getInstance();
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadMeizhi() {
            subscriber = new Subscriber<MeizhiBean>() {
                @Override
                public void onCompleted() {

                }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MeizhiBean resultsBean) {
               if(resultsBean.getResults().size()!=0){
                   Logger.error("yhd","datas != null");
                   mView.setData(resultsBean.getResults());


               }

            }


        };

    }

    @Override
    public void updateMeizhi() {

    }

    @Override
    public void success(boolean active) {


    }


    @Override
    public void start() {
        Random random=new Random();
        loadMeizhi();
        HttpMthodMeizhi.getInstance().getGankMeizi(subscriber,random.nextInt(45) ,random.nextInt(12));

    }
}
