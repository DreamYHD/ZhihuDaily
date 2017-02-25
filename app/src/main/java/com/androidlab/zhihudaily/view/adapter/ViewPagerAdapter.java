package com.androidlab.zhihudaily.view.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import com.androidlab.zhihudaily.presenter.DailyPresenter;
import com.androidlab.zhihudaily.presenter.MeizhiPresenter;
import com.androidlab.zhihudaily.presenter.SmilePresenter;
import com.androidlab.zhihudaily.view.fragment.CollectionFragment;
import com.androidlab.zhihudaily.view.fragment.DailyUiFragment;
import com.androidlab.zhihudaily.view.fragment.MeizhiFragment;
import com.androidlab.zhihudaily.view.fragment.RecentDailyFragment;
import com.androidlab.zhihudaily.view.fragment.SmileFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haodong on 2017/1/31.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private List<String> mTitles = new ArrayList<String>();

    private MeizhiFragment mMeizhiFragment;
    private DailyUiFragment mDailyUiFragment;
    private SmileFragment mSmileFragment;


    private Context mContext;


    public ViewPagerAdapter(FragmentManager fm,
                            Context context

    ) {
        super(fm);

        mMeizhiFragment=MeizhiFragment.newInstance();
        new MeizhiPresenter(mMeizhiFragment);
        mFragmentList.add(mMeizhiFragment);

        mDailyUiFragment=DailyUiFragment.newInstance();
        new DailyPresenter(mDailyUiFragment);
        mFragmentList.add(mDailyUiFragment);

        mSmileFragment=SmileFragment.newInstance();
        new SmilePresenter(mSmileFragment);
        mFragmentList.add(mSmileFragment);


        mTitles.add("图片欣赏");
        mTitles.add("新闻看看");
        mTitles.add("每日一笑");

        this.mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }

    @Override
    public int getCount() {

        return mFragmentList.size();
    }
}
