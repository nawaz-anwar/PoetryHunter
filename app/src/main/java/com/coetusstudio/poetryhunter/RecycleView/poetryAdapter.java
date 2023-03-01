package com.coetusstudio.poetryhunter.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coetusstudio.poetryhunter.Model.poetryModel;
import com.coetusstudio.poetryhunter.R;

import java.util.List;

public class poetryAdapter extends RecyclerView.Adapter<poetryAdapter.ViewHolder>{

    Context context;
    List<poetryModel> poetryModels;

    public poetryAdapter(Context context, List<poetryModel> poetryModels) {
        this.context = context;
        this.poetryModels = poetryModels;
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

    }

    @Override
    public int getItemCount() {
        return poetryModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView poetName, poetryDescription, poetryDate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            poetName = itemView.findViewById(R.id.poetName);
            poetryDescription = itemView.findViewById(R.id.poetryDescription);
            poetryDate = itemView.findViewById(R.id.poetryDate);
        }
    }
}
