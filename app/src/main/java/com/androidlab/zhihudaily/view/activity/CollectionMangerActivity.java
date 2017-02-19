package com.androidlab.zhihudaily.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.data.bean.Collection;
import com.androidlab.zhihudaily.data.manager.CollectionRepository;
import com.androidlab.zhihudaily.presenter.CollectionPresenter;
import com.androidlab.zhihudaily.utils.ActivityUtils;
import com.androidlab.zhihudaily.view.fragment.CollectionFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionMangerActivity extends AppCompatActivity {

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
    private List<Collection>mCollectionList=new ArrayList<>();
    private CollectionFragment collectionFragment=CollectionFragment.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        ButterKnife.bind(this);

        setSupportActionBar(mCollectionToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        ActivityUtils.replaceFragemntToActivity(getSupportFragmentManager(),collectionFragment,R.id.collection_coord);
        new CollectionPresenter(collectionFragment,new CollectionRepository());





    }
    @OnClick(R.id.float_action_button)
    public void add(){
        Intent intent=new Intent(this,CollectionSetingActivity.class);
        startActivityForResult(intent,100);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(20==resultCode){

            String noteContent=data.getExtras().getString("noteContent");
            String time=data.getExtras().getString("nowTime");
            Collection collection=new Collection(null,time,noteContent,null,null);
            collectionFragment.setCollectionList(collection);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
