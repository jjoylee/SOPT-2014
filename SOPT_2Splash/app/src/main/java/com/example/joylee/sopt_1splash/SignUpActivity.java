package com.example.joylee.sopt_1splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{
    Member member;
    EditText id, password, name, major;
    RadioGroup part, sex;
    Button submit, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        id = (EditText)findViewById(R.id.ID);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.name);
        major = (EditText)findViewById(R.id.major);
        part = (RadioGroup)findViewById(R.id.part);
        sex = (RadioGroup)findViewById(R.id.sex);
        submit = (Button)findViewById(R.id.submit);
        reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    public boolean validation(EditText text)
    {
        if(text.getText().length() == 0) return false;
        return true;
    }
    public boolean validation(RadioGroup radio)
    {
        if(radio.getCheckedRadioButtonId() == -1)return false;
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.submit:
                if((validation(id) && validation(password) && validation(name) && validation(major) && validation(sex) && validation(part)) == false)
                {
                    Log.i("id", String.valueOf(validation(id)));
                    Log.i("pw", String.valueOf(validation(password)));
                    Log.i("name", String.valueOf(validation(name)));
                    Log.i("major", String.valueOf(validation(major)));
                    Log.i("sex", String.valueOf(sex.isSelected()));
                    Log.i("part", String.valueOf(part.isSelected()));
                    Toast.makeText(getApplicationContext(), "빠진 정보가 있습니다. 확인해주세요", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    member = new Member();
                    member.setId(id.getText().toString());
                    member.setPassword(password.getText().toString());
                    member.setName(name.getText().toString());
                    member.setMajor(major.getText().toString());
                    member.setPart(((RadioButton)findViewById(part.getCheckedRadioButtonId())).getText().toString());
                    member.setSex(((RadioButton)findViewById(sex.getCheckedRadioButtonId())).getText().toString());
                    Intent intent = new Intent(getApplicationContext(), ImgSelectActivity.class);
                    intent.putExtra("Member", member);
                    startActivity(intent);
                    finish();
                }
                break;
            case R.id.reset:
                id.setText("");
                password.setText("");
                name.setText("");
                major.setText("");
                part.clearCheck();
                sex.clearCheck();
                break;
        }
    }
}
