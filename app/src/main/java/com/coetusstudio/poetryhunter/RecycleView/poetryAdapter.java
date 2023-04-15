package com.coetusstudio.poetryhunter.RecycleView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coetusstudio.poetryhunter.API.ApiClient;
import com.coetusstudio.poetryhunter.API.ApiInterface;
import com.coetusstudio.poetryhunter.Model.poetryModel;
import com.coetusstudio.poetryhunter.R;
import com.coetusstudio.poetryhunter.Response.DeletePoetryResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class poetryAdapter extends RecyclerView.Adapter<poetryAdapter.ViewHolder>{

    Context context;
    List<poetryModel> poetryModels;
    ApiInterface apiInterface;

    public poetryAdapter(Context context, List<poetryModel> poetryModels) {
        this.context = context;
        this.poetryModels = poetryModels;
        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.poetry_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.poetName.setText(poetryModels.get(position).getPoetName());
        holder.poetryDescription.setText(poetryModels.get(position).getPoetryDescription());
        holder.poetryDate.setText(poetryModels.get(position).getPoetryDate());

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletePoetry(poetryModels.get(position).getPoetryId()+"", position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return poetryModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView poetName, poetryDescription, poetryDate;
        Button updateBtn, deleteBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poetName = itemView.findViewById(R.id.poetName);
            poetryDescription = itemView.findViewById(R.id.poetryDescription);
            poetryDate = itemView.findViewById(R.id.poetryDate);
            updateBtn = itemView.findViewById(R.id.updateBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
        }
    }

    private void deletePoetry(String id, int position){
        apiInterface.deleteData(id).enqueue(new Callback<DeletePoetryResponse>() {
            @Override
            public void onResponse(Call<DeletePoetryResponse> call, Response<DeletePoetryResponse> response) {
                try {
                    if (response!=null){
                        Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    if (response.body().getStatus().equals("1")){
                        poetryModels.remove(position);
                        notifyDataSetChanged();
                    }
                }catch (Exception e){
                    Log.d("failure", e.getLocalizedMessage());
                }
            }

            @Override
            public void onFailure(Call<DeletePoetryResponse> call, Throwable t) {
                Log.d("failure", t.getLocalizedMessage());
            }
        });
    }
}
