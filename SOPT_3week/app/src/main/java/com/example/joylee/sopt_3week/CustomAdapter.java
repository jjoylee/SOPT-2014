package com.example.joylee.sopt_3week;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by JoyLee on 2017-04-15.
 */

public class CustomAdapter extends BaseAdapter {
    ArrayList<ItemData> itemDatas;

    public CustomAdapter(ArrayList<ItemData> itemDatas) {
        this.itemDatas = itemDatas;
    }

    @Override
    public int getCount() {
        return itemDatas != null ? itemDatas.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null)
        {
            LayoutInflater inflater  = (LayoutInflater)parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom, parent,false);
        }
        ImageView custom_img = (ImageView)view.findViewById(R.id.custom_item_img);
        TextView custom_title = (TextView)view.findViewById(R.id.custom_item_title);
        TextView custom_content = (TextView)view.findViewById(R.id.custom_item_content);

        custom_img.setImageResource(itemDatas.get(position).img);
        custom_title.setText(itemDatas.get(position).title);
        custom_content.setText(itemDatas.get(position).content);

        return view;
    }
}
