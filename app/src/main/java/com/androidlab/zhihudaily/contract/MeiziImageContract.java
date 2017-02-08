package com.androidlab.zhihudaily.contract;

import com.androidlab.zhihudaily.contract.base.BasePresenter;
import com.androidlab.zhihudaily.contract.base.BaseView;

/**
 * Created by Haodong on 2017/1/22.
 */

public interface MeiziImageContract {

    interface View extends BaseView<Presenter>{

        /**
         * 显示图片
         */

        void showMeizhi();


    }


    interface Presenter extends BasePresenter{

        /**
         * 加载图片
         */

        void loadMeizhi();

        /**
         * 更新图片
         */
        void updateMeizhi();

        /**
         * 加载指示器
         * @param active
         */
        void success(boolean active);
    }
}
