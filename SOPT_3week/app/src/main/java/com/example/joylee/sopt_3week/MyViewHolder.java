package com.example.joylee.sopt_3week;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by JoyLee on 2017-04-15.
 */

public class MyViewHolder extends RecyclerView.ViewHolder {
    ImageView recycler_img;
    TextView recycler_title;
    TextView recycler_content;
    public MyViewHolder(View itemView) {
        super(itemView);

        recycler_img = (ImageView)itemView.findViewById(R.id.custom_item_img);
        recycler_title = (TextView)itemView.findViewById(R.id.custom_item_title);
        recycler_content = (TextView)itemView.findViewById(R.id.custom_item_content);
    }
}
