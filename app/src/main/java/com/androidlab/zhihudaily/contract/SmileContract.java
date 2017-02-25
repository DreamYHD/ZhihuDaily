package com.androidlab.zhihudaily.contract;

import com.androidlab.zhihudaily.contract.base.BasePresenter;
import com.androidlab.zhihudaily.contract.base.BaseView;
import com.androidlab.zhihudaily.data.api.SmileApi;
import com.androidlab.zhihudaily.data.bean.SmileBean;

import java.util.List;

/**
 * Created by Haodong on 2017/2/24.
 */

public interface SmileContract {

    interface  View extends BaseView<Presenter>{

        void putData(List<SmileBean.ResultBean>list);
    }



    interface Presenter extends BasePresenter{

        void achieveSmile();

        void loadMore();

    }







}
