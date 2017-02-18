package com.androidlab.zhihudaily.presenter;

import com.androidlab.zhihudaily.contract.CollectionContract;
import com.androidlab.zhihudaily.data.manager.CollectionRepository;

/**
 * Created by Haodong on 2017/2/14.
 */

public class CollectionPresenter implements CollectionContract.Presenter {

    private CollectionContract.View mView;

    private CollectionRepository mCollectionRepository;

    public CollectionPresenter(CollectionContract.View view, CollectionRepository collectionRepository) {
        mView = view;
        mView.setPresenter(this);
        this.mCollectionRepository=collectionRepository;
    }

    @Override
    public void collectionThing() {




    }

    @Override
    public void start() {
        collectionThing();

    }
}
