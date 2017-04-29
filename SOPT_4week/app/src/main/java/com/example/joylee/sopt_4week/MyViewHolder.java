package com.example.joylee.sopt_4week;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JoyLee on 2017-04-29.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView custom_img;
    TextView custom_text;
    TextView custom_content;

    public MyViewHolder(View itemView) {
        super(itemView);
        custom_img = (ImageView)itemView.findViewById(R.id.custom_item_img);
        custom_content = (TextView)itemView.findViewById(R.id.custom_item_content);
        custom_text = (TextView)itemView.findViewById(R.id.custom_item_title);
    }
}
