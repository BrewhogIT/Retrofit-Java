package com.brewhog.android.retrofit_java.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    public AnekdotApi getApiArguments(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://umorili.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(AnekdotApi.class);
    }
}
