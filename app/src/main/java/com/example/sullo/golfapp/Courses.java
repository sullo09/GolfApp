package com.example.sullo.golfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Adaptor.MyAdapter;
import Model.ListItem;

public class Courses extends AppCompatActivity {

    TextView course;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.courses);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItems = new ArrayList<>();
        ListItem course1 = new ListItem("Old Conna Golf Club", "Ferndale Road, Oldconnaught, Bray, Co. Wicklow");
        ListItem course2 = new ListItem("Bray Golf Club", "Greystones Road, Bray, Co. Wicklow");
        ListItem course3 = new ListItem("Dun Laoghaire Golf Club", "Ferndale Road, Oldconnaught, Bray, Co. Wicklow");


//        for (int i = 0; i < 5; i++) {
//            ListItem item = new ListItem(
//                    "Item" + (i+1),
//                    "Description"
//            );
//            listItems.add(item);
//        }
        listItems.add(course1);
        listItems.add(course2);
        listItems.add(course3);


        adapter = new MyAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }
}
