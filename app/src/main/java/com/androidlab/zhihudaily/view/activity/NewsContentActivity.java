package com.androidlab.zhihudaily.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;

import com.androidlab.zhihudaily.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsContentActivity extends AppCompatActivity {

    @BindView(R.id.activity_news_tool)
    Toolbar mActivityNewsTool;
    @BindView(R.id.web_view)
    WebView mWebView;
    @BindView(R.id.activity_news_content)
    CoordinatorLayout mActivityNewsContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        ButterKnife.bind(this);
        setSupportActionBar(mActivityNewsTool);
        //设置返回按钮
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        String url=intent.getStringExtra("url");
        mWebView.loadUrl(url);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
