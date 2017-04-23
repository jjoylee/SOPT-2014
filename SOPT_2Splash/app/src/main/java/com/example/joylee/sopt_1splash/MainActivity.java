package com.example.joylee.sopt_1splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button signUp, loginBtn;
    EditText id, password;
    static boolean first = true;
    Member member;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          if(first)
          {
            first = false;
            startActivity(new Intent(this, SplashActivity.class));
          }

        loginBtn = (Button)findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation(id)&&validation(password))
                {
                    if(member.getId().equals(id.getText().toString()))
                    {
                        if(member.getPassword().equals(password.getText().toString()))  Toast.makeText(getApplicationContext(),"로그인에 성공하셨습니다.", Toast.LENGTH_SHORT).show();
                        else Toast.makeText(getApplicationContext(),"비밀번호가 틀립니다..", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"ID가 틀립니다.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        id = (EditText)findViewById(R.id.loginId);
        password = (EditText)findViewById(R.id.loginPwd);

        signUp = (Button)findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });

        member = (Member)(getIntent().getSerializableExtra("Member"));

    }

    public boolean validation(EditText text)
    {
        if(text.getText().length() == 0 )return false;
        return true;
    }

}
