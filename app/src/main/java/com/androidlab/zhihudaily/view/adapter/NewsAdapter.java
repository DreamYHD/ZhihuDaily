package com.androidlab.zhihudaily.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.data.bean.NewsBean;
import com.androidlab.zhihudaily.utils.Logger;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Haodong on 2017/2/10.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {



    private List<NewsBean.StoriesBean> mNewsBeanList = new ArrayList<>();
    private List<NewsBean.TopStoriesBean> mNewsBeanListTop = new ArrayList<>();
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    private Context mContext;


    public NewsAdapter(List<NewsBean.StoriesBean> newsBeanList, List<NewsBean.TopStoriesBean> newsBeanListTop, Context context) {
        mNewsBeanList = newsBeanList;
        mContext = context;
        mNewsBeanListTop = newsBeanListTop;

    }


    //define interface
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView, position); // 2
                }
            });
        }
        if (position < mNewsBeanList.size()) {
            Glide.with(mContext)
                    .load(mNewsBeanList.get(position).getImages().get(0))
                    .placeholder(R.drawable.load)
                    .override(250, 250)
                    .fitCenter()
                    .into(holder.mImageView);
            holder.mTextView.setText(mNewsBeanList.get(position).getTitle());
            Logger.debug("yhdyhd", position + "");


        } else {
            Glide.with(mContext)
                    .load(mNewsBeanListTop.get(position - mNewsBeanList.size()).getImage())
                    .placeholder(R.drawable.load)
                    .override(250, 250)
                    .fitCenter()
                    .into(holder.mImageView);
            holder.mTextView.setText(mNewsBeanListTop.get(position - mNewsBeanList.size()).getTitle());
            Logger.debug("yhdyhd", position + "");
        }

    }


    @Override
    public int getItemCount() {

        return mNewsBeanList.size() + mNewsBeanListTop.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.daily_image);
            mTextView = (TextView) itemView.findViewById(R.id.item_daily);
        }
    }
}
