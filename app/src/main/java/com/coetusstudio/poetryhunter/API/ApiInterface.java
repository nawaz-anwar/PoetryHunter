package com.coetusstudio.poetryhunter.API;

import com.coetusstudio.poetryhunter.Response.GetPoetryResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("getdata.php")
    Call<GetPoetryResponse> getPoetryData();
}
