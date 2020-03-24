package com.e.loginapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiLoader {

    private static final String BASE_URL = "https://mytown-app.com/api/";
    private static Retrofit retrofit;

    public static Retrofit fetchApi() {
            retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            return retrofit;
    }

}