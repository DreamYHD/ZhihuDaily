package com.androidlab.zhihudaily.contract;

import com.androidlab.zhihudaily.contract.base.BasePresenter;
import com.androidlab.zhihudaily.contract.base.BaseView;
import com.androidlab.zhihudaily.data.bean.NewsBean;
import com.androidlab.zhihudaily.view.adapter.NewsAdapter;

import java.util.List;

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
         * 传入数据
         */
        void setDate(List<NewsBean.StoriesBean>storiesBeen,List<NewsBean.TopStoriesBean>topStoriesBeen);

        /**
         * 跳转到下个页面
         * @param url
         */

        void goNewsDetail(String url);




    }
    interface  Presenter extends BasePresenter{

        /**
         * 加载最近的新闻
         */

        void loadLatestDaily();

        /**
         * 加载新闻的新具体内容e：10213
         * @param id
         */

        void loadDaily(int  id);

        /**
         * 加载指示器
         * @param Action
         */

        void scccess(boolean Action);

    }

}
