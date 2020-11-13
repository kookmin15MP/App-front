package com.example.kmu_regist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private void sendLoginRequest(LoginDataSet loginDataSet) {
        final boolean isRight = false;

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://3.34.158.76:8100")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        Login login = retrofit.create(Login.class);
        Call<LoginDataSet> call = login.loginAccount(loginDataSet);

        call.enqueue(new Callback<LoginDataSet>() {
            @Override
            public void onResponse(Call<LoginDataSet> call, Response<LoginDataSet> response) {
                Log.d("test", "onResponse() returned: " + response);
                Toast.makeText(LoginActivity.this, "로그인에 성공하였습니다 id:" + response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginDataSet> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(LoginActivity.this, "에러입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText email = (EditText) findViewById(R.id.idText);
        final EditText pw = (EditText) findViewById(R.id.passwordText);
        final Button loginButton = (Button) findViewById(R.id.loginButton);

        TextView helpButton = (TextView) findViewById(R.id.helpButton);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent helpIntent = new Intent(LoginActivity.this, HelpActivity.class);
                LoginActivity.this.startActivity(helpIntent);
            }
        });

        Button signupButton = (Button) findViewById(R.id.signupButton);
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signupIntent = new Intent( LoginActivity.this, SignupActivity.class);
                LoginActivity.this.startActivity(signupIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginDataSet loginDataSet = new LoginDataSet(
                    email.getText().toString(),
                    pw.getText().toString()
            );
                sendLoginRequest(loginDataSet);

                Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            }
        });

    }
}