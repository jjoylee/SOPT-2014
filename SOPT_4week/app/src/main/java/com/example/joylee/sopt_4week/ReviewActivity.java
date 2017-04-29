package com.example.joylee.sopt_4week;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ItemData> itemDatas;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        recyclerView = (RecyclerView)findViewById(R.id.rcv);
        recyclerView.setHasFixedSize(true);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        itemDatas = new ArrayList<ItemData>();
        itemDatas.add(new ItemData(R.drawable.bluetree, "1번 제목", "1번 내용"));
        itemDatas.add(new ItemData(R.drawable.redtree, "2번 제목", "2번 내용"));
        itemDatas.add(new ItemData(R.drawable.greentree, "3번 제목", "3번 내용"));

        recyclerAdapter = new RecyclerAdapter(itemDatas, clickListener);
        recyclerView.setAdapter(recyclerAdapter);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final int pos = recyclerView.getChildPosition(v);
            Toast.makeText(getApplicationContext(), (pos+1)+"번 클릭", Toast.LENGTH_SHORT).show();
        }
    };
}
