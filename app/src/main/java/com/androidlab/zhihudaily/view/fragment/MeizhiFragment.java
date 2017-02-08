package com.androidlab.zhihudaily.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.contract.MeiziImageContract;

/**
 * Created by Haodong on 2017/1/23.
 */

public class MeizhiFragment extends BaseFragment implements MeiziImageContract.View {
    private MeiziImageContract.Presenter mPresenter;

    public static MeizhiFragment newInstance() {
        return new MeizhiFragment();

    }


    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.meizhi_image_layout,null);



        return view;


    }

    @Override
    public void showMeizhi() {

    }

    @Override
    public void setPresenter(MeiziImageContract.Presenter presenter) {
        mPresenter = presenter;

    }
}
