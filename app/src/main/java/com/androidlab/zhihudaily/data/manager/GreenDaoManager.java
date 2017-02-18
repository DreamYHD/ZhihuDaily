package com.androidlab.zhihudaily.data.manager;

import com.androidlab.zhihudaily.MyApplication;
import com.androidlab.zhihudaily.data.local.DaoMaster;
import com.androidlab.zhihudaily.data.local.DaoSession;

/**
 * Created by Haodong on 2017/2/14.
 */

public class GreenDaoManager {

    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;
    private static GreenDaoManager mInstance;

    private GreenDaoManager() {

        if (mDaoMaster == null) {
            DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster
                    .DevOpenHelper(MyApplication.getContext(), "note_db", null);
            mDaoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
            mDaoSession = mDaoMaster.newSession();


        }


    }

    public static GreenDaoManager getInstance() {
        if (mInstance == null) {
            synchronized (GreenDaoManager.class) {
                if ((mInstance) == null) {
                    mInstance = new GreenDaoManager();
                }
            }

        }
        return mInstance;

    }

    public DaoMaster getDaoMaster() {

        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public DaoSession getNewDaoSession() {
        mDaoSession = mDaoMaster.newSession();
        return mDaoSession;

    }

}
