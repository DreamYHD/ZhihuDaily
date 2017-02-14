package com.androidlab.zhihudaily;

import android.app.Application;
import android.content.Context;

/**
 * Created by Haodong on 2017/2/14.
 */

public class MyApplication extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
    }

    public static Context getContext(){
        return mContext;

    }
}
