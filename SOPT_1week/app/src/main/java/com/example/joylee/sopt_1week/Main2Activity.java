package com.example.joylee.sopt_1week;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("activity2", "onStart2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("activity2", "onDestroy2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("activity2", "onStop2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("activity2", "onResume2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("activity2", "onPause2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("activity2", "onRestart2");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button3;
        Button button4;
        TextView textView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView = (TextView)findViewById(R.id.text2);
        Intent getData = getIntent();
        String str = getData.getStringExtra("mail").toString();
        textView.setText(str);
        button3 = (Button)findViewById(R.id.finishbtn);
        button4 = (Button)findViewById(R.id.resultbtn);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent();
                intent3.putExtra("result", "값 주고받기 성공");
                setResult(RESULT_OK, intent3);
                finish();
            }
        });
        Log.i("activity2", "onCreate2");
    }
}
