package com.androidlab.zhihudaily.contract;

import com.androidlab.zhihudaily.contract.base.BasePresenter;
import com.androidlab.zhihudaily.contract.base.BaseView;

/**
 * Created by Haodong on 2017/1/21.
 */

public interface ZhihuDailyContract {


    interface  View extends BaseView<Presenter>{

        /**
         * 显示新闻
         */

        void showDailyNews();

        /**
         * 跳转到下个页面
         * @param newsId
         */

        void goNewsDetail(String newsId);




    }
    interface  Presenter extends BasePresenter{

        /**
         * 加载最近的新闻
         */

        void loadLatestDaily(String news);

        /**
         * 加载某一天的新闻 time：2017-06-23
         * @param time
         */

        void loadDaily(String time);

        /**
         * 加载指示器
         * @param Action
         */

        void scccess(boolean Action);

    }

}
