package com.example.sullo.golfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import Adaptor.RoundRecyclerAdapter;
import Adaptor.ShotAdapter;
import Model.CompletedRound;
import Model.Shot;

public class RecordedYardages extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;

    private ShotAdapter shotAdapter;
    private RecyclerView ShotRecyclerView;
//    private RecyclerView.Adapter adapter;
    private List<Shot> shotList;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorded_yardages);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Shot");
        databaseReference.keepSynced(true);


        shotList = new ArrayList<>();
        ShotRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewShot);
        ShotRecyclerView.setHasFixedSize(true);
        ShotRecyclerView.setLayoutManager(new  LinearLayoutManager(this));
        //extras = getIntent().getExtras();

    }

    //used so everything is set up before the onCreate runs.
    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
// each roundResult is mapped to the RoundResult object
                Shot shotRecorded = dataSnapshot.getValue(Shot.class);

                shotList.add(shotRecorded);

                shotAdapter = new ShotAdapter(RecordedYardages.this, shotList);
                ShotRecyclerView.setAdapter(shotAdapter);
                shotAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

//
//    Bundle bundle= getIntent().getExtras();
//        String record = bundle.getString("record");
//
//        shotList = new ArrayList<>();
//
////        Shot shot = new Shot(record,"180");
////        shotList.add(shot);
////        Log.d("shotList","shot recording");
//        for (int i = 0; i < 5; i++) {
//            Shot shot = new Shot(
//                    record + (i+1),
//                    "description"
//            );
//            shotList.add(shot);
//        }
//        adapter = new ShotAdapter(this, shotList);
//        recyclerView.setAdapter(adapter);
