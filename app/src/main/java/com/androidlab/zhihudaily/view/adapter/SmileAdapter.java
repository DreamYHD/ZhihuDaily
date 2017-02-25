package com.androidlab.zhihudaily.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.data.bean.SmileBean;
import com.androidlab.zhihudaily.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haodong on 2017/2/24.
 */

public class SmileAdapter extends RecyclerView.Adapter<SmileAdapter.ViewHolder> {

    private List<SmileBean.ResultBean>mResultBeen=new ArrayList<>();

    private  OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public SmileAdapter(List<SmileBean.ResultBean> resultBeen) {
        mResultBeen = resultBeen;
    }

    public  interface OnRecyclerViewItemClickListener{
         void onItemClick(View view,int position);
     }
    public void setOnItemClickListener(OnRecyclerViewItemClickListener onItemClickListener){
        this.mOnRecyclerViewItemClickListener=onItemClickListener;

    }


    @Override
    public SmileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.smile_item_layout,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SmileAdapter.ViewHolder holder, int position) {

        holder.mTime.setText(mResultBeen.get(position).getUpdatetime());
        holder.mContent.setText(mResultBeen.get(position).getContent());
        holder.mTitle.setText(mResultBeen.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return mResultBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mTime;
        private TextView mContent;


        public ViewHolder(View itemView) {
            super(itemView);
            mTitle= (TextView) itemView.findViewById(R.id.title_smile);
            mContent= (TextView) itemView.findViewById(R.id.content_smile);
            mTime= (TextView) itemView.findViewById(R.id.time_smile);
        }
    }
}
