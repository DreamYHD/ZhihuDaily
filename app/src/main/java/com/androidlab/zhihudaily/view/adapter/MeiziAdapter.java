package com.androidlab.zhihudaily.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.data.bean.MeizhiBean;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Haodong on 2017/1/30.
 */

public class MeiziAdapter extends RecyclerView.Adapter<MeiziAdapter.ViewHolder> {


    private static List<MeizhiBean.ResultsBean> images = new ArrayList<MeizhiBean.ResultsBean>();
    private Context mContext;

    public MeiziAdapter(Context context, List<MeizhiBean.ResultsBean> list) {

        images = list;
        mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meizi, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (null != images.
                get(position).getUrl()) {
            Glide.with(mContext)
                    .load(images.get(position).getUrl())
                    .placeholder(R.drawable.load)
                    .override(750, 750)
                    .fitCenter()
                    .into(holder.mImageView);


        }


    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;


        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.item_image);

        }
    }
}
