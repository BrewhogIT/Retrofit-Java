package com.brewhog.android.retrofit_java.api;

import com.brewhog.android.retrofit_java.pojo.Anekdot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AnekdotApi {
    @GET("/api/get")
    Call<List<Anekdot>> getAnekdots(@Query("name")String name, @Query("num")Integer num);
}
