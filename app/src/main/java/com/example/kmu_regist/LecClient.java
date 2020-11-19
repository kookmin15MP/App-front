package com.example.kmu_regist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LecClient {

    private static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.34.158.76:8100/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Addlecture addlecture(){
        Addlecture addlecture = getRetrofit().create(Addlecture.class);

        return addlecture;
    }
}
