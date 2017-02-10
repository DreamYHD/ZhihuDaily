package com.androidlab.zhihudaily.view.activity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.utils.ActivityUtils;
import com.androidlab.zhihudaily.utils.ShowToast;
import com.androidlab.zhihudaily.view.adapter.ViewPagerAdapter;
import com.androidlab.zhihudaily.view.fragment.CollectionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "yanghaodong";


    @BindView(R.id.coordinator_main_layout)
    CoordinatorLayout mCoordinatorMainLayout;
    @BindView(R.id.navigation_view)
    NavigationView mDesignNavigationView;
    @BindView(R.id.drawer_main)
    DrawerLayout mDrawerMain;
    @BindView(R.id.main_toolbar)
    Toolbar mMainToolbar;
    @BindView(R.id.enter_floating_button)
    FloatingActionButton mEnterFloatingButton;
    @BindView(R.id.tab_head)
    TabLayout mTabHead;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;

    private long time = 0;
    private ViewPagerAdapter mViewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置toolbar
        setSupportActionBar(mMainToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.navi_star);
        actionBar.setDisplayHomeAsUpEnabled(true);


        initView();
        setlistener();

    }

    @OnClick(R.id.enter_floating_button)
    public void say(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

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
        CollectionFragment collection = CollectionFragment.newInstance();
        ActivityUtils.replaceFragemntToActivity(getSupportFragmentManager(), collection, R.layout.activity_other);
    }

    private void initView() {
        mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        mViewPager.setAdapter(mViewPagerAdapter);
        mTabHead.setupWithViewPager(mViewPager);


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

