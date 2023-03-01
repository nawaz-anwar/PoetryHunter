package com.coetusstudio.poetryhunter.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.coetusstudio.poetryhunter.Model.poetryModel;
import com.coetusstudio.poetryhunter.R;
import com.coetusstudio.poetryhunter.RecycleView.poetryAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewPoetry;
    poetryAdapter poetryAdapter;
    List<poetryModel> poetryModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPoetry = findViewById(R.id.recycleViewPoetry);

        poetryModels.add(new poetryModel("1","Mirza Galib", "Humein Shayar Samajh Ke Yoon Najar Andaz Mat Kariye" +
                "Najar Hum Fer Le To Husn Ka Baazar Gir Jayega.","26-01-2021"));

        poetryModels.add(new poetryModel("2","Mirza Galib", "Humein Shayar Samajh Ke Yoon Najar Andaz Mat Kariye,\n" +
                "Najar Hum Fer Le To Husn Ka Baazar Gir Jayega.","26-01-2021"));

        poetryModels.add(new poetryModel("3","Mirza Galib", "Humein Shayar Samajh Ke Yoon Najar Andaz Mat Kariye,\n" +
                "Najar Hum Fer Le To Husn Ka Baazar Gir Jayega.","26-01-2021"));



        setData(poetryModels);

    }

    private void setData(List<poetryModel> poetryModels) {

        poetryAdapter = new poetryAdapter(this, poetryModels);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewPoetry.setLayoutManager(linearLayoutManager);
        recyclerViewPoetry.setAdapter(poetryAdapter);

    }
}