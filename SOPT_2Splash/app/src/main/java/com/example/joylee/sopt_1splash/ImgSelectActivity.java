package com.example.joylee.sopt_1splash;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class ImgSelectActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView mainImg;
    Button prev, next, join;
    Member member;
    Spinner month, year, day;
    ArrayList<String> imgArr = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_select);
        Intent intent = getIntent();
        member = (Member)(intent.getSerializableExtra("Member"));
        // image index 찾아서 계산하기 위해 ArrayList생성
        imgArr.add("greentree"); // index == 0
        imgArr.add("bluetree"); // index == 1
        imgArr.add("redtree"); // index == 2
        mainImg = (ImageView)findViewById(R.id.mainImg);
        member.setImg(R.drawable.bluetree);     //defalut로 bluetree
        prev = (Button)findViewById(R.id.prevBtn);
        prev.setOnClickListener(this);
        next = (Button)findViewById(R.id.nextBtn);
        next.setOnClickListener(this);
        join = (Button)findViewById(R.id.join);
        join.setOnClickListener(this);
        month = (Spinner)findViewById(R.id.month);
        year = (Spinner)findViewById(R.id.year);
        day = (Spinner)findViewById(R.id.day);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.prevBtn:
                rotate(mainImg.getTag().toString(), -1); // prev면 imgArr index -1
                break;
            case R.id.nextBtn:
                rotate(mainImg.getTag().toString(), +1); // next면 imgArr index + 1
                break;
            case R.id.join:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ImgSelectActivity.this);
                alertDialogBuilder
                        .setMessage("회원가입을 하시겠습니까?")
                        .setCancelable(false)
                        .setPositiveButton("확인", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                member.setBirthYear(year.getSelectedItem().toString());
                                member.setBirthMonth(month.getSelectedItem().toString());
                                member.setBirthDay(day.getSelectedItem().toString());
                                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                                intent.putExtra("Member", member);
                                startActivity(intent);
                                finish();
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
                break;
        }
    }

    //이미지 변경을 위한 함수
    public void rotate(String imgName, int cal)
    {
        //index 계산
        int idx = imgArr.indexOf(imgName);
        idx = idx + cal;
        if(idx == -1){ idx = 2; }
        if(idx == 3){ idx = 0; }

        //index에 따른 image지정
        if(idx == 0)
        {
            mainImg.setImageResource(R.drawable.greentree);
            mainImg.setTag("greentree");
            member.setImg(R.drawable.greentree);
        }
        else if(idx == 1)
        {
            mainImg.setImageResource(R.drawable.bluetree);
            mainImg.setTag("bluetree");
            member.setImg(R.drawable.bluetree);
        }
        else
        {
            mainImg.setImageResource(R.drawable.redtree);
            mainImg.setTag("redtree");
            member.setImg(R.drawable.redtree);
        }
    }
}
