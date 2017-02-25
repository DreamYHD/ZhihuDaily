package com.androidlab.zhihudaily.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.contract.ZhihuDailyContract;
import com.androidlab.zhihudaily.data.bean.NewsBean;
import com.androidlab.zhihudaily.presenter.DailyPresenter;
import com.androidlab.zhihudaily.utils.Logger;
import com.androidlab.zhihudaily.utils.MyDecoration;
import com.androidlab.zhihudaily.view.activity.NewsContentActivity;
import com.androidlab.zhihudaily.view.adapter.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Haodong on 2017/1/23.
 */

public class DailyUiFragment extends BaseFragment implements ZhihuDailyContract.View {
    private static ZhihuDailyContract.Presenter mPresenter;
    @BindView(R.id.news_recyclerView)
    RecyclerView mNewsRecyclerView;
    private NewsAdapter mNewsAdapter;
    private LinearLayoutManager mLinearLayoutManager;
    private List<NewsBean.StoriesBean> mNewsBeanList;
    private List<NewsBean.TopStoriesBean> mTopStoriesBeanList;


    public static DailyUiFragment newInstance() {


        return new DailyUiFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(mPresenter!=null){
            mPresenter.start();

        }else {
            mPresenter=new DailyPresenter(this);
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.daily_news_layout, container, false);
        ButterKnife.bind(this, view);
        mNewsBeanList = new ArrayList<NewsBean.StoriesBean>();
        mTopStoriesBeanList = new ArrayList<NewsBean.TopStoriesBean>();
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mNewsAdapter = new NewsAdapter(mNewsBeanList, mTopStoriesBeanList, getContext());
        mNewsRecyclerView.setAdapter(mNewsAdapter);
        mNewsRecyclerView.setLayoutManager(mLinearLayoutManager);
        mNewsRecyclerView.addItemDecoration(new MyDecoration(getContext(), MyDecoration.HORIZONTAL_LIST));
        mNewsAdapter.setOnItemClickListener(new NewsAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (position < mNewsBeanList.size()) {
                    mPresenter.loadDaily(mNewsBeanList.get(position).getId());
                    Logger.debug("dailyUI", mNewsBeanList.get(position).getId() + "");
                } else {
                    mPresenter.loadDaily(mTopStoriesBeanList.get(position - mNewsBeanList.size()).getId());

                }


            }
        });


        return view;

    }

    @Override
    public void showDailyNews() {

    }

    @Override
    public void setDate(List<NewsBean.StoriesBean> storiesBeen, List<NewsBean.TopStoriesBean> topStoriesBeen) {
        this.mNewsBeanList.clear();
        this.mTopStoriesBeanList.clear();
        this.mNewsBeanList.addAll(storiesBeen);
        this.mTopStoriesBeanList.addAll(topStoriesBeen);
        mNewsAdapter.notifyDataSetChanged();

    }


    @Override
    public void goNewsDetail(String url) {
        Intent intent = new Intent(getContext(), NewsContentActivity.class);
        intent.putExtra("url", url);
        startActivity(intent);//将Intent传递给Activity

    }

    @Override
    public void setPresenter(ZhihuDailyContract.Presenter presenter) {
        mPresenter = presenter;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter=null;
    }
}
