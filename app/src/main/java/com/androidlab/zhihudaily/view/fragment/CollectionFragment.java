package com.androidlab.zhihudaily.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.contract.CollectionContract;
import com.androidlab.zhihudaily.data.bean.Collection;
import com.androidlab.zhihudaily.utils.MyDecoration;
import com.androidlab.zhihudaily.view.adapter.CollectionAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Haodong on 2017/1/23.
 */

public class CollectionFragment extends BaseFragment implements CollectionContract.View {

    @BindView(R.id.recycle_collection)
    RecyclerView mRecycleCollection;
    private CollectionContract.Presenter mPresenter;
    private List<Collection> mCollectionList;
    private CollectionAdapter mCollectionAdapter;
    private LinearLayoutManager mLinearLayoutManager;


    @Override
    public void onResume() {
        super.onResume();

        mPresenter.start();
    }

    public static CollectionFragment newInstance() {

        return new CollectionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCollectionList = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.collection_enjoy_layout, null);
        ButterKnife.bind(this, view);
        mRecycleCollection.setLayoutManager(mLinearLayoutManager);
        mRecycleCollection.setAdapter(mCollectionAdapter);
        mRecycleCollection.addItemDecoration(new MyDecoration(getContext(),MyDecoration.HORIZONTAL_LIST));

        return view;
    }

    @Override
    public void show(List<Collection> mCollectionList) {
        this.mCollectionList = mCollectionList;


    }

    @Override
    public void setPresenter(CollectionContract.Presenter presenter) {
        this.mPresenter = presenter;

    }
}
