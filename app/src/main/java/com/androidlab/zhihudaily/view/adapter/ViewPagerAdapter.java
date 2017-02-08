package com.androidlab.zhihudaily.view.adapter;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.List;

/**
 * Created by Haodong on 2017/1/31.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<String> mTitle;
    private List<Fragment> mFragmentList;

    private Context mContext;


    public ViewPagerAdapter(FragmentManager fm,
                            Context context,
                            List<Fragment> mFragmentLists,
                            List<String> mTitles
                            ) {
        super(fm);

        this.mTitle=mTitles;
        this.mFragmentList = mFragmentLists;
        this.mContext = context;

    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    public CharSequence getPageTitle(int position) {
            return mTitle.get(position);
    }

    @Override
    public int getCount() {

        return mFragmentList.size();
    }
}
