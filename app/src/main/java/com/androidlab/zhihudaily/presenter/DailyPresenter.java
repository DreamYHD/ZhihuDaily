package com.androidlab.zhihudaily.presenter;

import android.support.annotation.NonNull;

import com.androidlab.zhihudaily.contract.ZhihuDailyContract;

/**
 * Created by Haodong on 2017/1/22.
 */

public class DailyPresenter implements ZhihuDailyContract.Presenter {
    @NonNull
    private final ZhihuDailyContract.View mView;

    public DailyPresenter(@NonNull ZhihuDailyContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }


    @Override
    public void loadLatestDaily(String news) {

    }

    @Override
    public void loadDaily(String time) {

    }

    @Override
    public void scccess(boolean Action) {


    }

    @Override
    public void start() {

    }
}
