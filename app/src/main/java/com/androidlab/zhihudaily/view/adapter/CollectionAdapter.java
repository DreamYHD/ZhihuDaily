package com.androidlab.zhihudaily.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidlab.zhihudaily.R;
import com.androidlab.zhihudaily.data.bean.Collection;
import com.androidlab.zhihudaily.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haodong on 2017/2/14.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.ViewHolder> {

    private List<Collection> mCollectionList = new ArrayList<>();
    private Context mContext;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public CollectionAdapter(List<Collection> collectionList, Context context) {
        mCollectionList = collectionList;
        mContext = context;
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        mOnRecyclerViewItemClickListener = listener;
    }


    @Override
    public CollectionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_item, null);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CollectionAdapter.ViewHolder holder, int position) {

        if (mOnRecyclerViewItemClickListener != null) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnRecyclerViewItemClickListener.onItemClick(holder.itemView, position);

                }
            });

        }
        Logger.debug("adaptertest",mCollectionList.get(position).getNoteText().toString());

        holder.timeView.setText(mCollectionList.get(position).getTime().toString());
        holder.contView.setText(mCollectionList.get(position).getNoteText().toString());

    }

    @Override
    public int getItemCount() {
        return mCollectionList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView timeView;
        private TextView contView;
        public ViewHolder(View itemView) {
            super(itemView);
            timeView= (TextView) itemView.findViewById(R.id.time_item);
            contView= (TextView) itemView.findViewById(R.id.collection_content_item);
        }
    }
}
