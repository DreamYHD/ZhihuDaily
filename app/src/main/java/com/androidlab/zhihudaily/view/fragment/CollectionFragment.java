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

public class CollectionFragment extends BaseFragment {

    public static CollectionFragment newInstance(){

        return new CollectionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.collection_enjoy_layout,null);
        return view;
    }
}
