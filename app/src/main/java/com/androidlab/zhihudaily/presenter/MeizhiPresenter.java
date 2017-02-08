package com.androidlab.zhihudaily.presenter;

import android.support.annotation.NonNull;

import com.androidlab.zhihudaily.contract.MeiziImageContract;
import com.androidlab.zhihudaily.data.bean.MeizhiBean;
import com.androidlab.zhihudaily.data.getdata.HttpMthodMeizhi;

import rx.Subscriber;

/**
 * Created by Haodong on 2017/1/22.
 */

public class MeizhiPresenter implements MeiziImageContract.Presenter {

    private final MeiziImageContract.View mView;

    private HttpMthodMeizhi mHttpMthodMeizhi;


    public MeizhiPresenter(MeiziImageContract.View view) {

        mHttpMthodMeizhi=HttpMthodMeizhi.getInstance();
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void loadMeizhi() {
        mHttpMthodMeizhi.getGankMeizi(new Subscriber<MeizhiBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(MeizhiBean meizhiBean) {



            }
        },0,10);

    }

    @Override
    public void updateMeizhi() {

    }

    @Override
    public void success(boolean active) {

    }


    @Override
    public void start() {
        loadMeizhi();

    }
}
