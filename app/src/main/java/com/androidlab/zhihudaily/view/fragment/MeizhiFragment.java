package com.androidlab.zhihudaily.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.contract.MeiziImageContract;
import com.androidlab.zhihudaily.data.bean.MeizhiBean;
import com.androidlab.zhihudaily.view.adapter.MeiziAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Haodong on 2017/1/23.
 */

public class MeizhiFragment extends BaseFragment implements MeiziImageContract.View {

    private MeiziImageContract.Presenter mPresenter;
    @BindView(R.id.meizi_recycle_view)
    RecyclerView mMeiziRecycleView;
    private MeiziAdapter mMeiziAdapter;
    private List<MeizhiBean.ResultsBean> list = new ArrayList<MeizhiBean.ResultsBean>();

    private StaggeredGridLayoutManager mLayoutManager;

    public static MeizhiFragment newInstance() {
        return new MeizhiFragment();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mMeiziAdapter = new MeiziAdapter(getContext(), list);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.meizhi_image_layout, null);
        ButterKnife.bind(this, view);
        mMeiziRecycleView.setLayoutManager(mLayoutManager);
        mMeiziRecycleView.setAdapter(mMeiziAdapter);
        mMeiziRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                //判断是否滑动到底部
                if (!ViewCompat.canScrollVertically(recyclerView, 1)) {

                    mPresenter.start();

                }
            }
        });

        return view;
    }

    @Override
    public void setPresenter(MeiziImageContract.Presenter presenter) {
        mPresenter = presenter;
    }

    //添加数据
    public void setData(List<MeizhiBean.ResultsBean> list) {

        this.list.addAll(list);

        mMeiziAdapter.notifyDataSetChanged();


    }


    @Override
    public void onDestroy() {

        super.onDestroy();
    }
}
