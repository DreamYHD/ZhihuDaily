package com.androidlab.zhihudaily.presenter;

import com.androidlab.zhihudaily.contract.CollectionContract;
import com.androidlab.zhihudaily.data.bean.Collection;
import com.androidlab.zhihudaily.data.manager.CollectionRepository;
import com.androidlab.zhihudaily.utils.Logger;

/**
 * Created by Haodong on 2017/2/14.
 */

public class CollectionPresenter implements CollectionContract.Presenter {

    private CollectionContract.View mView;

    private CollectionRepository mCollectionRepository;

    public CollectionPresenter(CollectionContract.View view, CollectionRepository collectionRepository) {
        this.mView = view;
        mView.setPresenter(this);
        this.mCollectionRepository=collectionRepository;
    }

    @Override
    public void collectionThing() {
        mView.show(mCollectionRepository.queryCollection());


    }
    public void addColl(Collection collection){
        mCollectionRepository.addCollection(collection);
        mView.show(mCollectionRepository.queryCollection());
        Logger.debug("gettest",mCollectionRepository.queryCollection().get(0).getNoteText());

    }

    @Override
    public void remove(Collection collection) {
        mCollectionRepository.deleteCollection(collection);
        mView.show(mCollectionRepository.queryCollection());

    }

    @Override
    public void start() {
        collectionThing();

    }
}
