package com.androidlab.zhihudaily.contract.base;

import android.view.View;

/**
 * Created by Haodong on 2017/1/21.
 */

public interface BaseView<T> {
    /**
     * 给view设置一presenter
     * @param presenter
     */
    void setPresenter(T presenter);

}
