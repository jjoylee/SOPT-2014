package com.example.joylee.sopt_4week;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by JoyLee on 2017-04-29.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
    ArrayList<ItemData> itemDatas;
    View.OnClickListener onClickListener;

    public RecyclerAdapter(ArrayList<ItemData> itemDatas, View.OnClickListener onClickListener) {
        this.itemDatas = itemDatas;
        this.onClickListener = onClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_recyclerview_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(onClickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.custom_img.setImageResource(itemDatas.get(position).img);
        holder.custom_text.setText(itemDatas.get(position).title);
        holder.custom_content.setText(itemDatas.get(position).content);
    }

    @Override
    public int getItemCount() {
        return itemDatas != null ? itemDatas.size() : 0 ;
    }
}
