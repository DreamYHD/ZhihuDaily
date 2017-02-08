package com.androidlab.zhihudaily.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Haodong on 2017/1/23.
 */

public class ShowToast {

    public static void showShortToast(String toast, Context context){
        Toast.makeText(context, toast, Toast.LENGTH_SHORT).show();

    }
    public static void showLongToast(String toast, Context context){
        Toast.makeText(context, toast, Toast.LENGTH_LONG).show();

    }
}
