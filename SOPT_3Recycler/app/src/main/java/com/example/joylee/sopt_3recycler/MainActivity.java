package com.example.joylee.sopt_3recycler;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ItemData> itemDatas;
    RecyclerAdapter recyclerAdapter;
    LinearLayoutManager linearLayoutManager;
    Button add;
    Button prev;
    Button next;
    EditText imgText;
    EditText searchText;
    TextView imgNum;
    ButtonListener buttonListener;
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonListener = new ButtonListener();
        add = (Button)findViewById(R.id.add);
        add.setOnClickListener(buttonListener);
        prev = (Button)findViewById(R.id.prev);
        prev.setOnClickListener(buttonListener);
        next = (Button)findViewById(R.id.next);
        next.setOnClickListener(buttonListener);
        imgText = (EditText)findViewById(R.id.imgText);
        imgNum = (TextView)findViewById(R.id.imgNum);

        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        searchText = (EditText)findViewById(R.id.searchText);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), DividerItemDecoration.VERTICAL));
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        itemDatas = new ArrayList<ItemData>();
        itemDatas.add(new ItemData(id++, R.drawable.redtree, "테스트1"));
        itemDatas.add(new ItemData(id++, R.drawable.bluetree, "테스트2"));
        itemDatas.add(new ItemData(id++, R.drawable.greentree, "테스트3"));

        recyclerAdapter = new RecyclerAdapter(itemDatas, clickListener);

        searchText.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text =searchText.getText().toString().toLowerCase(Locale.getDefault());
                recyclerAdapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });


        recyclerView.setAdapter(recyclerAdapter);
    }

    public View.OnClickListener clickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            final int position = recyclerView.getChildPosition(v);
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("해당 항목을 삭제 하시겠습니까?")
                    .setCancelable(false)
                    .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            id = itemDatas.get(position).id;
                            Log.i("id", Integer.toString(id));
                            recyclerAdapter.deleteItem(id);
                            searchText.setText("");
                        }
                    })
                    .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    };

    public class ButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            int num = Integer.parseInt(imgNum.getText().toString());
            switch (v.getId()) {
                case R.id.add:
                    String text = ((EditText) findViewById(R.id.imgText)).getText().toString();
                    if (num == 0) recyclerAdapter.addItem(new ItemData(id++,R.drawable.redtree, text));
                    else if (num == 1) recyclerAdapter.addItem(new ItemData(id++,R.drawable.bluetree, text));
                    else recyclerAdapter.addItem(new ItemData(id++,R.drawable.greentree, text));
                    searchText.setText("");
                    ((EditText)findViewById(R.id.imgText)).setText("");
                    break;
                case R.id.prev:
                    if(num == 0) num = 2;
                    else num = num - 1;
                    imgNum.setText(Integer.toString(num));
                    break;
                case R.id.next:
                    if(num == 2) num = 0;
                    else num = num +1;
                    imgNum.setText(Integer.toString(num));
                    break;
            }
        }
    }
}
