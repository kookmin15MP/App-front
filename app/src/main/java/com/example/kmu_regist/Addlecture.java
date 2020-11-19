package com.example.kmu_regist;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Addlecture {
    @POST("api/lecture/info")
    Call<AddlecResponse> addLec(@Body AddlecDataSet addlecDataSet);
}
