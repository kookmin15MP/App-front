package com.example.kmu_regist;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText email = (EditText) findViewById(R.id.log_id);
        final EditText pw = (EditText) findViewById(R.id.log_pw);
        final Button btn_Signup = (Button) findViewById(R.id.btn_signup);

        btn_Signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SignupDataSet signupDataSet = new SignupDataSet(
                        email.getText().toString(),
                        pw.getText().toString()
                );
                sendSignupRequest(signupDataSet);
            }
        });
    }
    private void sendSignupRequest(SignupDataSet signupDataSet) {
        final boolean isRight = false;

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://3.34.158.76:8100")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        API api = retrofit.create(API.class);
        Call<SignupDataSet> call = api.createAccount(signupDataSet);

        call.enqueue(new Callback<SignupDataSet>() {
            @Override
            public void onResponse(Call<SignupDataSet> call, Response<SignupDataSet> response) {
                Log.d("test", "onResponse() returned: " + response);
                Toast.makeText(SignupActivity.this, "회원가입에 성공하였습니다 id:" + response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<SignupDataSet> call, Throwable t) {
                System.out.println(t);
                Toast.makeText(SignupActivity.this, "에러입니다", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
