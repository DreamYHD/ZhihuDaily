package com.androidlab.zhihudaily.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.contract.SmileContract;
import com.androidlab.zhihudaily.data.bean.SmileBean;
import com.androidlab.zhihudaily.view.adapter.SmileAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Haodong on 2017/2/24.
 */

public class SmileFragment extends BaseFragment implements SmileContract.View {

    @BindView(R.id.smile_recycle)
    RecyclerView mSmileRecycle;
    @BindView(R.id.float_smile)
    FloatingActionButton mFloatSmile;
    @BindView(R.id.smile_progress)
    ContentLoadingProgressBar mSmileProgress;
    private SmileAdapter mSmileAdapter;
    private SmileContract.Presenter mPresenter;
    private List<SmileBean.ResultBean> mResultBeen;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static SmileFragment newInstance() {

        return new SmileFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();

    }

    @OnClick(R.id.float_smile)
    public void changeSmile() {
        mPresenter.loadMore();
        mSmileProgress.show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.smile_fragment_layout, null);
        ButterKnife.bind(this, view);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mResultBeen = new ArrayList<>();
        mSmileAdapter = new SmileAdapter(mResultBeen);
        mSmileRecycle.setLayoutManager(mLinearLayoutManager);
        mSmileRecycle.setAdapter(mSmileAdapter);
        mSmileAdapter.setOnItemClickListener(new SmileAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {


            }
        });


        return view;
    }

    @Override
    public void putData(List<SmileBean.ResultBean> list) {
        mResultBeen.clear();
        mResultBeen.addAll(list);
        mSmileAdapter.notifyDataSetChanged();
        mSmileProgress.hide();
        mSmileRecycle.scrollToPosition(0);
    }

    @Override
    public void setPresenter(SmileContract.Presenter presenter) {
        this.mPresenter = presenter;



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
