package com.androidlab.zhihudaily;

import android.app.Application;
import android.content.Context;

import com.androidlab.zhihudaily.data.getdata.HttpMethodDaily;
import com.androidlab.zhihudaily.data.getdata.HttpMthodMeizhi;
import com.androidlab.zhihudaily.data.manager.GreenDaoManager;

/**
 * Created by Haodong on 2017/2/14.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        //全局配置，只希望single有一个数据库操作对象
        GreenDaoManager.getInstance();
        HttpMethodDaily.getInstance();
        HttpMthodMeizhi.getInstance();
    }

    public static Context getContext() {
        return mContext;

    }
}
