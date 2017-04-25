package com.example.joylee.sopt_3recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by JoyLee on 2017-04-23.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ListViewHolder> {
    ArrayList<ItemData> itemDatas;
    ArrayList<ItemData> searchDatas;
    View.OnClickListener clickListener;

    public RecyclerAdapter(ArrayList<ItemData> itemDatas, View.OnClickListener clickListener) {
        this.itemDatas = itemDatas;
        this.clickListener = clickListener;
        searchDatas = new ArrayList<ItemData>();
        searchDatas.addAll(itemDatas);
    }

    public void addItem(ItemData data)
    {
        searchDatas.add(data);
        itemDatas.add(data);
        notifyDataSetChanged();
    }

    public void deleteItem(int id)
    {
        for(int i = 0; i <searchDatas.size(); i++) if(searchDatas.get(i).id == id) searchDatas.remove(i);
        for(int i = 0; i <itemDatas.size(); i++) if(itemDatas.get(i).id == id) itemDatas.remove(i);
        notifyDataSetChanged();
    }
    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagelist, parent, false);
        ListViewHolder listViewHolder = new ListViewHolder(view);
        view.setOnClickListener(clickListener);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.list_img.setImageResource(itemDatas.get(position).img);
        holder.list_text.setText(itemDatas.get(position).content);

    }

    @Override
    public int getItemCount() {
        return itemDatas != null ? itemDatas.size() : 0 ;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        itemDatas.clear();
        if (charText.length() == 0) {
            itemDatas.addAll(searchDatas);
        }
        else
        {
            for (ItemData searchItem : searchDatas)
            {
                if (searchItem.content.toLowerCase(Locale.getDefault()).contains(charText))
                {
                    itemDatas.add(searchItem);
                }
            }
        }
        notifyDataSetChanged();
    }
}
