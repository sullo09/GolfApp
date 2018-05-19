package com.example.sullo.golfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Adaptor.RoundRecyclerAdapter;
import Adaptor.ShotAdapter;
import Model.Shot;

public class RecordedYardages extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Shot> shotList;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorded_yardages);

        shotList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewShot);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new  LinearLayoutManager(this));
        extras = getIntent().getExtras();

        Bundle bundle= getIntent().getExtras();
        String record = bundle.getString("record");

        shotList = new ArrayList<>();

//        Shot shot = new Shot(record,"180");
//        shotList.add(shot);
//        Log.d("shotList","shot recording");
        for (int i = 0; i < 5; i++) {
            Shot shot = new Shot(
                    record + (i+1),
                    "description"
            );
            shotList.add(shot);
        }
        adapter = new ShotAdapter(this, shotList);
        recyclerView.setAdapter(adapter);
    }
}
