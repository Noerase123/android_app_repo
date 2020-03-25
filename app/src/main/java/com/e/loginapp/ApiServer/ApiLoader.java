package com.e.loginapp.ApiServer;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiLoader {

    private static Retrofit retrofit;

    public static Retrofit fetchApi() {
            retrofit = new Retrofit.Builder()
                .baseUrl(KeyPoints.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

            return retrofit;
    }

}