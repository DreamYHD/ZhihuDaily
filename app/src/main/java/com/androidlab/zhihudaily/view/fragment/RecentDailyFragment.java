package com.androidlab.zhihudaily.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlab.zhihudaily.R;

/**
 * Created by Haodong on 2017/1/23.
 */

public class RecentDailyFragment extends BaseFragment {

    public static RecentDailyFragment newInstance(){

        return new RecentDailyFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.recent_daily_layout,null);
        return view;
    }
}
