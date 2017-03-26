package com.example.joylee.sopt_1week;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_CODE = 2017;
    TextView textView;
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("activity1", "onStart1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("activity1", "onDestroy1");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("activity1", "onStop1");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("activity1", "onResume1");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("activity1", "onPause1");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("activity1", "onRestart1");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE) {
                textView.setText(data.getStringExtra("result").toString());
                Toast.makeText(getApplicationContext(), "resultmsg = " + data.getStringExtra("result").toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button2;
        Button button;

        // bundle = save important record
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("activity1", "onCreate1");

        textView = (TextView)findViewById(R.id.text1);
        button = (Button)findViewById(R.id.btn1);
        button2 = (Button)findViewById(R.id.btn2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), Main2Activity.class);
                intent2.putExtra("mail", "값이 전달되었습니다2");
                startActivityForResult(intent2, REQUEST_CODE);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                intent.putExtra("mail","값이 전달되었습니다.");
                startActivity(intent);
            }
        });
    }
}
