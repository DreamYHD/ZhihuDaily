package com.androidlab.zhihudaily;

import android.Manifest;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.androidlab.zhihudaily.data.getdata.HttpMethodDaily;
import com.androidlab.zhihudaily.data.getdata.HttpMethodDown;
import com.androidlab.zhihudaily.data.getdata.HttpMethodSmile;
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
        //全局配置，只希望single有一个操作对象
        GreenDaoManager.getInstance();
        HttpMethodDaily.getInstance();
        HttpMthodMeizhi.getInstance();
        HttpMethodSmile.getInstance();
        HttpMethodDown.getInstance();

    }

    public static Context getContext() {
        return mContext;

    }
}
