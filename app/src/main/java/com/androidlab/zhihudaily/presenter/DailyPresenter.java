package com.androidlab.zhihudaily.presenter;



import com.androidlab.zhihudaily.contract.ZhihuDailyContract;
import com.androidlab.zhihudaily.utils.Logger;
import com.androidlab.zhihudaily.utils.ShowToast;

/**
 * Created by Haodong on 2017/1/22.
 */

public class DailyPresenter implements ZhihuDailyContract.Presenter {

    private final ZhihuDailyContract.View mView;

    public DailyPresenter(ZhihuDailyContract.View view) {
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
        Logger.debug("nonono","hello");

    }
}
