package com.example.joylee.sopt_3week;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<ItemData> itemDatas;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView)findViewById(R.id.list);
        itemDatas = new ArrayList<ItemData>();
        itemDatas.add(new ItemData(R.drawable.bluetree, "1번 제목", "1번 내용"));
        itemDatas.add(new ItemData(R.drawable.redtree, "2번 제목", "2번 내용"));
        itemDatas.add(new ItemData(R.drawable.greentree, "3번 제목", "3번 내용"));
        itemDatas.add(new ItemData(R.drawable.bluetree, "4번 제목", "4번 내용"));
        itemDatas.add(new ItemData(R.drawable.redtree, "5번 제목", "5번 내용"));
        itemDatas.add(new ItemData(R.drawable.greentree, "6번 제목", "6번 내용"));

        customAdapter = new CustomAdapter(itemDatas);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), (position + 1)+ "번 클릭!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
