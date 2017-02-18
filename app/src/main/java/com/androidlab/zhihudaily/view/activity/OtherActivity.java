package com.androidlab.zhihudaily.view.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.androidlab.zhihudaily.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherActivity extends AppCompatActivity {

    @BindView(R.id.collection_toolbar)
    Toolbar mCollectionToolbar;
    @BindView(R.id.collection_appbar)
    AppBarLayout mCollectionAppbar;
    @BindView(R.id.collection_coord)
    CoordinatorLayout mCollectionCoord;
    @BindView(R.id.activity_other)
    CoordinatorLayout mActivityOther;
    @BindView(R.id.float_action_button)
    FloatingActionButton mFloatActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);
        setSupportActionBar(mCollectionToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);


    }
    @OnClick(R.id.float_action_button)
    public void add(){


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

        }


        return super.onOptionsItemSelected(item);
    }
}
