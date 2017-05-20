package com.example.joylee.sopt_1splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
    TextView resultId, resultPwd, resultMajor, resultPart, resultSex, resultName, resultYear, resultMonth, resultDay;
    ImageView resultImg;
    Member member;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        member = (Member)(getIntent().getSerializableExtra("Member"));
        resultId = (TextView)findViewById(R.id.reusltId);
        resultPwd = (TextView)findViewById(R.id.reusltPwd);
        resultMajor = (TextView)findViewById(R.id.reusltMajor);
        resultPart = (TextView)findViewById(R.id.reusltPart);
        resultSex = (TextView)findViewById(R.id.reusltSex);
        resultName = (TextView)findViewById(R.id.reusltName);
        resultYear = (TextView)findViewById(R.id.reusltYear);
        resultMonth = (TextView)findViewById(R.id.reusltMonth);
        resultDay = (TextView)findViewById(R.id.reusltDay);
        resultImg = (ImageView)findViewById(R.id.resultImg);
        login = (Button)findViewById(R.id.login);

        resultImg.setImageResource(member.getImg());
        resultId.setText(member.getId());
        resultPwd.setText(member.getPassword());
        resultMajor.setText(member.getMajor());
        resultPart.setText(member.getPart());
        resultSex.setText(member.getSex());
        resultName.setText(member.getName());
        resultYear.setText(member.getBirthYear());
        resultMonth.setText(member.getBirthMonth());
        resultDay.setText(member.getBirthDay());

        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("Member", member);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
        finish();
    }
}
