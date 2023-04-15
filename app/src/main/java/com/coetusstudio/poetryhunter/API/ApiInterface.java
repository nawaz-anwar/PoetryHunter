package com.coetusstudio.poetryhunter.API;

import com.coetusstudio.poetryhunter.Response.DeletePoetryResponse;
import com.coetusstudio.poetryhunter.Response.GetPoetryResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("getdata.php")
    Call<GetPoetryResponse> getPoetryData();

    @FormUrlEncoded
    @POST("deletepoetry.php")
    Call<DeletePoetryResponse> deleteData(@Field("poetry_id") String poetry_id);
}
