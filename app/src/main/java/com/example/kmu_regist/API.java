package com.example.kmu_regist;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {

    @POST("/api/authorization/signup")
    Call<SignupDataSet> createAccount(@Body SignupDataSet signupDataSet);

}
