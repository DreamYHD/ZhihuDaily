package com.androidlab.zhihudaily.contract;

import com.androidlab.zhihudaily.contract.base.BasePresenter;
import com.androidlab.zhihudaily.contract.base.BaseView;
import com.androidlab.zhihudaily.data.bean.Collection;

import java.util.List;

/**
 * Created by Haodong on 2017/2/14.
 */

public interface CollectionContract {

    interface View extends BaseView<Presenter> {

        void show(List<Collection> mCollectionList);


    }

    interface Presenter extends BasePresenter {

        void collectionThing();


    }


}
