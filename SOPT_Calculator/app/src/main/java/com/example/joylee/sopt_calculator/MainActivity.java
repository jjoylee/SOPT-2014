package com.example.joylee.sopt_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button add;
    Button sub;
    Button result;
    int resultNum;
    EditText edit;
    String operation;
    int currentNum1 = 0;
    int currentNum2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 변수들 뷰와 연결
        edit = (EditText)findViewById(R.id.editText);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        add = (Button)findViewById(R.id.add);
        sub = (Button)findViewById(R.id.sub);
        result = (Button)findViewById(R.id.result);

        //리스너 객체 생성
        ClickListener listener = new ClickListener();

        //리스너 연결
        btn1.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        add.setOnClickListener(listener);
        sub.setOnClickListener(listener);
        // result버튼을 누르면 operating 함수로 결과 계산 및 intent로 결과 전달
        result.setOnClickListener(listener);
    }

    private void operating(int currentNum1, int currentNum2, String operation) {
        switch (operation){
            case "add":
                resultNum = currentNum1 + currentNum2;
                break;
            case "sub":
                resultNum = currentNum1 - currentNum2;
                break;
        }
    }

    class ClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.add:
                    operation = "add";
                    break;
                case R.id.sub:
                    operation = "sub";
                    break;
                case R.id.result:
                    operating(currentNum1, currentNum2, operation);
                    Intent resultIntent = new Intent(getApplicationContext(), ResultActivity.class);
                    resultIntent.putExtra("result", resultNum);
                    startActivity(resultIntent);
                    break;
                default:
                    if(edit.getText().toString().length() != 0) {
                        currentNum1 = Integer.parseInt(edit.getText().toString());
                        currentNum2 = Integer.parseInt(((Button)v).getText().toString());
                    }
                    else {
                        //edittext가 null일 때 currentnum1=0이 된다.(처음에 초기화 시켜 줌)
                        currentNum2 = Integer.parseInt(((Button)v).getText().toString());
                    }
            }
        }
    }
}

