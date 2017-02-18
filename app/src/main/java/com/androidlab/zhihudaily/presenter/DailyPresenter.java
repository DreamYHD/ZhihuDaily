package com.androidlab.zhihudaily.presenter;



import com.androidlab.zhihudaily.contract.ZhihuDailyContract;
import com.androidlab.zhihudaily.data.bean.NewsBean;
import com.androidlab.zhihudaily.data.bean.NewsContentBean;
import com.androidlab.zhihudaily.data.getdata.HttpMethodDaily;
import com.androidlab.zhihudaily.utils.Logger;
import com.androidlab.zhihudaily.utils.ShowToast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import rx.Subscriber;

/**
 * Created by Haodong on 2017/1/22.
 */

public class DailyPresenter implements ZhihuDailyContract.Presenter {

    private final ZhihuDailyContract.View mView;



    public DailyPresenter(ZhihuDailyContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    private Subscriber mSubscriber;

    private Subscriber mContentSubscribe;


    @Override
    public void loadLatestDaily() {

        mSubscriber=new Subscriber<NewsBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsBean newsBean) {
                if(newsBean.getStories()!=null||newsBean.getTop_stories()!=null){
                    Logger.error("yhd","daily!=null");
                    mView.setDate(newsBean.getStories(),newsBean.getTop_stories());

                }

            }

        };

    }
    private void loadDailyContent() {

        mContentSubscribe=new Subscriber<NewsContentBean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(NewsContentBean newsContentBean) {
                String url=newsContentBean.getShare_url();
                Logger.debug("presenter",url+"");
                Logger.debug("presenter",newsContentBean.toString());
                mView.goNewsDetail(url);
            }


        };
    }


    @Override
    public void loadDaily(int id) {
        loadDailyContent();
        HttpMethodDaily.getInstance().getNewContent(mContentSubscribe,id);

    }



    @Override
    public void scccess(boolean Action) {


    }

    @Override
    public void start() {
        loadLatestDaily();
        HttpMethodDaily.getInstance().getNewLatest(mSubscriber);

    }
}
