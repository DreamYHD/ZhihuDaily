package com.androidlab.zhihudaily.view.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.utils.ShowToast;
import com.androidlab.zhihudaily.view.adapter.ViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.hugeterry.coordinatortablayout.CoordinatorTabLayout;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "yanghaodong";
    @BindView(R.id.navigation_view)
    NavigationView mDesignNavigationView;
    @BindView(R.id.drawer_main)
    DrawerLayout mDrawerMain;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.coordinatortablayout)
    CoordinatorTabLayout mCoordinatortablayout;

    private long time = 0;
    private ViewPagerAdapter mViewPagerAdapter;
    public static final int[] mColorArray = new int[]{
            android.R.color.holo_blue_light,
            android.R.color.holo_blue_light,
    };
    public static final int[] mImageArray  = new int[]{
            R.drawable.timg,
            R.drawable.timgtwo
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置toolbar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.navi_star);
        actionBar.setDisplayHomeAsUpEnabled(true);


        initView();
        setlistener();

    }


    private void setlistener() {

        // TODO: 2017/1/23 侧滑栏监听事件
        if (mDesignNavigationView != null) {
            mDesignNavigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            switch (item.getItemId()) {
                                case R.id.image_collection:
                                    openCollection();
                                    break;
                                case R.id.daily_provide:

                                    break;
                            }
                            mDrawerMain.closeDrawers();
                            return true;
                        }
                    });
        }
    }

    private void openCollection() {
        Intent intent = new Intent(this, CollectionMangerActivity.class);
        startActivity(intent);

    }

    private void initView() {
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mViewPagerAdapter);
        mCoordinatortablayout.setTitle("干货日报")
                .setupWithViewPager(mViewPager)
                .setImageArray(mImageArray,mColorArray);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - time > 2000) {
            ShowToast.showShortToast("再按一次 退出应用！", this);
            time = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    //actionbar启动侧滑
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerMain.openDrawer(GravityCompat.START);
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
}

