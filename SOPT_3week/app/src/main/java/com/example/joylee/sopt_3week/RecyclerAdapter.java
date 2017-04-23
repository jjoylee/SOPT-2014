package com.example.joylee.sopt_3week;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by JoyLee on 2017-04-15.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder>{
    ArrayList<ItemData> itemDatas;
    View.OnClickListener clickListener;

    public RecyclerAdapter(ArrayList<ItemData> itemDatas, View.OnClickListener clickListener) {
        this.itemDatas = itemDatas;
        this.clickListener = clickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(clickListener);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.recycler_img.setImageResource(itemDatas.get(position).img);
        holder.recycler_content.setText(itemDatas.get(position).content);
        holder.recycler_title.setText(itemDatas.get(position).title);
    }

    @Override
    public int getItemCount() {
        return itemDatas != null ? itemDatas.size() : 0 ;
    }
}
