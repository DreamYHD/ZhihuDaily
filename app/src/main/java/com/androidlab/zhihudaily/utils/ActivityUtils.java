package com.androidlab.zhihudaily.utils;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.androidlab.zhihudaily.view.fragment.CollectionFragment;

/**
 * Created by Haodong on 2017/1/31.
 */

public class ActivityUtils {
    private ActivityUtils(){


    }
    public static void addFragmentToActivity(FragmentManager fragmentManager,
                                             Fragment fragment,
                                             int frameId){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(frameId,fragment);
        fragmentTransaction.commit();

    }
    public  static void replaceFragemntToActivity(FragmentManager fragmentManager,
                                                  Fragment fragment,
                                                  int frameId){
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameId,fragment);
        fragmentTransaction.commit();
    }


}
