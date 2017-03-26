package com.example.joylee.sopt_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView resultText = (TextView)findViewById(R.id.resultText);
        resultText.setText(String.valueOf(getIntent().getIntExtra("result", 0 )).toString());
    }
}
