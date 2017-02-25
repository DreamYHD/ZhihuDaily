package com.androidlab.zhihudaily.presenter;

import com.androidlab.zhihudaily.contract.SmileContract;
import com.androidlab.zhihudaily.data.bean.SmileBean;
import com.androidlab.zhihudaily.data.getdata.HttpMethodSmile;
import com.androidlab.zhihudaily.utils.Logger;

import java.util.Random;

import rx.Subscriber;

/**
 * Created by Haodong on 2017/2/24.
 */

public class SmilePresenter  implements SmileContract.Presenter{

    private SmileContract.View mView;

    private Subscriber<SmileBean>mSubscriber;

    public static int page=2;


    public SmilePresenter(SmileContract.View view) {

        this.mView=view;
        mView.setPresenter(this);



    }

    @Override
    public void achieveSmile() {
        mSubscriber=new Subscriber<SmileBean>() {
            @Override
            public void onCompleted() {
                Logger.debug("yanghaodong","加载完成");

            }

            @Override
            public void onError(Throwable e) {
                Logger.error("yanghaodong","网络出错");

            }

            @Override
            public void onNext(SmileBean smileBean) {
                mView.putData(smileBean.getResult());

            }
        };

    }

    @Override
    public void loadMore() {
        Random random=new Random();
        achieveSmile();
        HttpMethodSmile.getInstance().getSmile(mSubscriber,10,random.nextInt(4450));

    }


    @Override
    public void start() {
        Random random=new Random();
        achieveSmile();
        HttpMethodSmile.getInstance().getSmile(mSubscriber,10,random.nextInt(4450));
    }
}
