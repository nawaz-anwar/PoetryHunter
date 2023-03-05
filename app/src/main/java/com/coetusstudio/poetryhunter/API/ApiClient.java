package com.coetusstudio.poetryhunter.API;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static Retrofit RETROFIT = null;

    public static Retrofit getClient(){

        if (RETROFIT==null) {

            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

            Gson gson = new Gson().newBuilder().create();

            RETROFIT = new Retrofit.Builder()
                    .baseUrl("http://localhost/poetryapi/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create(gson)).build();
        }

        return RETROFIT;
    }
}
