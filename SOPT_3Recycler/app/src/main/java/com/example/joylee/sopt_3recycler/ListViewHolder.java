package com.example.joylee.sopt_3recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JoyLee on 2017-04-23.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {
    ImageView list_img;
    TextView list_text;
    public ListViewHolder(View itemView) {
        super(itemView);
        list_img = (ImageView)itemView.findViewById(R.id.list_img);
        list_text = (TextView)itemView.findViewById(R.id.list_text);
    }
}
