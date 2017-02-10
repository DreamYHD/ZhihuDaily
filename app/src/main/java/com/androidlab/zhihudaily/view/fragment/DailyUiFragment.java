package com.androidlab.zhihudaily.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.contract.ZhihuDailyContract;
import com.androidlab.zhihudaily.presenter.DailyPresenter;

/**
 * Created by Haodong on 2017/1/23.
 */

public class DailyUiFragment extends BaseFragment implements ZhihuDailyContract.View {
    private static ZhihuDailyContract.Presenter mPresenter;


    public static DailyUiFragment newInstance() {


        return new DailyUiFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.daily_news_layout, container, false);

    }

    @Override
    public void showDailyNews() {

    }

    @Override
    public void goNewsDetail(String newsId) {

    }

    @Override
    public void setPresenter(ZhihuDailyContract.Presenter presenter) {
        this.mPresenter = presenter;

    }
}
