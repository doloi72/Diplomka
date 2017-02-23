package com.example.doloi.diplomka.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.doloi.diplomka.R;
import com.example.doloi.diplomka.model.ListItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by doloi on 14.2.2017.
 */

public class DerpAdapter extends RecyclerView.Adapter<DerpAdapter.DerpHolder>{

    public interface ItemClickCallback<T>{
        void onItemClick(T t);
        void onSecondaryIconClick(T t, int position);
    }

    private List<ListItem> listData;
    private LayoutInflater inflater;

    private ItemClickCallback<ListItem> itemClickCallback;

    public DerpAdapter(List<ListItem> listData, Context c, ItemClickCallback<ListItem> itemItemClickCallback){
        this.inflater = LayoutInflater.from(c);
        this.listData = listData;
        this.itemClickCallback = itemItemClickCallback;
    }

    @Override
    public DerpHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new DerpHolder(view);
    }

    @Override
    public void onBindViewHolder(DerpHolder holder, int position) {
        final ListItem item = listData.get(position);
        final int finalPosition = position;
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
        if (item.isCheck()){
            holder.secondIcon.setImageResource(R.drawable.ic_check_box_black_24dp);
        } else{
            holder.secondIcon.setImageResource(R.drawable.ic_check_box_outline_blank_black_24dp);
        }

        // add click listener
        // TODO: 23.02.17 retrolambda - library pro používání streamů z Java 8 v Javě 7
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickCallback.onItemClick(item);
            }
        });

        holder.secondIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickCallback.onSecondaryIconClick(item, finalPosition);
            }
        });
    }

    public void setListData(ArrayList<ListItem> exerciseList){
        this.listData.clear();
        this.listData.addAll(exerciseList);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class DerpHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView subTitle;
        private ImageView icon;
        private ImageView secondIcon;

        public DerpHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            subTitle = (TextView)itemView.findViewById(R.id.lbl_sub_title);
            icon = (ImageView)itemView.findViewById(R.id.im_item_icon);
            secondIcon = (ImageView)itemView.findViewById(R.id.im_item_icon_secondary);
        }
    }
}
