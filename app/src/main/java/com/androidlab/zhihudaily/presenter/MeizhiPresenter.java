package com.androidlab.zhihudaily.presenter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.androidlab.zhihudaily.contract.MeiziImageContract;
import com.androidlab.zhihudaily.data.bean.MeizhiBean;
import com.androidlab.zhihudaily.data.getdata.HttpMethodDown;
import com.androidlab.zhihudaily.data.getdata.HttpMthodMeizhi;
import com.androidlab.zhihudaily.utils.Logger;

import java.util.Random;

import rx.Subscriber;

/**
 * Created by Haodong on 2017/1/22.
 */

public class MeizhiPresenter implements MeiziImageContract.Presenter {

    private final MeiziImageContract.View mView;


    private Subscriber subscriber;

    private Subscriber mDownSubscriber;


    public MeizhiPresenter(MeiziImageContract.View view) {

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
                if (resultsBean.getResults().size() != 0) {
                    Logger.error("yhd", "datas != null");
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
    public void downloadImage(String url) {

        mDownSubscriber=new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }
            @Override
            public void onError(Throwable e) {
            }
            @Override
            public void onNext(String string) {
                if (string!=null){
                    mView.showToast("图片下载成功"+string);
                }
            }
        };
        HttpMethodDown.getInstance().downloadImage(mDownSubscriber,url);
    }


    @Override
    public void start() {
        Random random = new Random();
        loadMeizhi();
        HttpMthodMeizhi.getInstance().getGankMeizi(subscriber, random.nextInt(45), random.nextInt(12));

    }
}
