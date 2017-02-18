package com.androidlab.zhihudaily.data.manager;

import com.androidlab.zhihudaily.data.bean.Collection;

import java.util.List;

/**
 * Created by Haodong on 2017/2/15.
 */

public interface CollectionDataSource {

    void addCollection(Collection collection);

    void deleteCollection(Collection collection);

    void updataCollection();

    List<Collection> queryCollection();

}
