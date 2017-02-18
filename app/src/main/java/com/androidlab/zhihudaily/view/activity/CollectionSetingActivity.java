package com.androidlab.zhihudaily.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.androidlab.zhihudaily.R;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CollectionSetingActivity extends AppCompatActivity {


    @BindView(R.id.setting_toolbar)
    Toolbar mSettingToolbar;
    @BindView(R.id.add_note)
    EditText mAddNote;
    @BindView(R.id.complete_collection)
    Button mCompleteCollection;
    @BindView(R.id.activity_collection_seting)
    LinearLayout mActivityCollectionSeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection_seting);
        ButterKnife.bind(this);
        setSupportActionBar(mSettingToolbar);
    }

    @OnClick(R.id.complete_collection)
    public void complete() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日   HH:mm:ss");
        Date curDate = new Date(System.currentTimeMillis());
        String time = formatter.format(curDate);
        Intent intent = new Intent();
        intent.putExtra("nowTime", time);
        intent.putExtra("noteContent",mAddNote.getText().toString() );
        setResult(20,intent);
        finish();


    }
}
