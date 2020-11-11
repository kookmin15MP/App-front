package com.example.kmu_regist;

import android.app.AppComponentFactory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText log_Id = (EditText) findViewById(R.id.log_id);
        final EditText log_Pw = (EditText) findViewById(R.id.log_pw);
        final Button btn_Signup = (Button) findViewById(R.id.btn_signup);

        btn_Signup.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String email = log_Id.getText().toString();
                String pw = log_Pw.getText().toString();
            }
        });

    }
}
