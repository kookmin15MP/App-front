package com.example.kmu_regist;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Login {
    @POST("/api/authorization/login")
    Call<LoginDataSet> loginAccount(@Body LoginDataSet loginDataSet);

}
