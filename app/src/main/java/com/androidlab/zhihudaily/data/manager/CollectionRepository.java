package com.androidlab.zhihudaily.data.manager;

import com.androidlab.zhihudaily.data.bean.Collection;
import com.androidlab.zhihudaily.data.local.CollectionDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haodong on 2017/2/15.
 */

public class CollectionRepository implements CollectionDataSource {


    private CollectionDao getCollectionDao() {
        return GreenDaoManager.getInstance().getDaoSession().getCollectionDao();

    }

    @Override
    public void addCollection(Collection collection) {
        getCollectionDao().insert(collection);


    }

    @Override
    public void deleteCollection(Collection collection) {

        getCollectionDao().delete(collection);
    }

    @Override
    public void updataCollection() {

    }

    @Override
    public List<Collection> queryCollection() {
        List<Collection> list = getCollectionDao().loadAll();
        return list;
    }
}
