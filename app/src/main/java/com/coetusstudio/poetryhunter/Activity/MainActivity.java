package com.coetusstudio.poetryhunter.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.coetusstudio.poetryhunter.API.ApiClient;
import com.coetusstudio.poetryhunter.API.ApiInterface;
import com.coetusstudio.poetryhunter.Model.poetryModel;
import com.coetusstudio.poetryhunter.R;
import com.coetusstudio.poetryhunter.RecycleView.poetryAdapter;
import com.coetusstudio.poetryhunter.Response.GetPoetryResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewPoetry;
    poetryAdapter poetryAdapter;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialization();

        getdata();

    }

    private void initialization() {
        recyclerViewPoetry = findViewById(R.id.recycleViewPoetry);
        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    private void setData(List<poetryModel> poetryModels) {

        poetryAdapter = new poetryAdapter(this, poetryModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPoetry.setLayoutManager(linearLayoutManager);
        recyclerViewPoetry.setAdapter(poetryAdapter);

    }

    private void getdata() {
        apiInterface.getPoetryData().enqueue(new Callback<GetPoetryResponse>() {
            @Override
            public void onResponse(Call<GetPoetryResponse> call, Response<GetPoetryResponse> response) {

                try {

                    if (response!=null){
                        if (response.body().getStatus().equals("1")){
                            Log.e("DataAaya", String.valueOf(response));
                            setData(response.body().getData());

                        }else {
                            Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                }catch (Exception e){
                    Log.e("Exception", e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(Call<GetPoetryResponse> call, Throwable t) {
                Log.e("Failed to get data", t.getLocalizedMessage());
            }
        });
    }
}