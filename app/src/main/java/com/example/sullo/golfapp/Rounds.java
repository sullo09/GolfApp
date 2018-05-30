package com.example.sullo.golfapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
import Model.CompletedRound;

public class Rounds extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;

    private RoundRecyclerAdapter roundRecyclerAdapter;
    private RecyclerView RoundsRecyclerView;
    private List<CompletedRound> completedRoundList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rounds);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference().child("Rounds");
        databaseReference.keepSynced(true);

        completedRoundList = new ArrayList<>();
        RoundsRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewIDRounds);
        RoundsRecyclerView.setHasFixedSize(true);
        RoundsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
//used so everything is set up before the onCreate runs.
    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
// each roundResult is mapped to the RoundResult object
                CompletedRound roundResults = dataSnapshot.getValue(CompletedRound.class);

                completedRoundList.add(roundResults);

                roundRecyclerAdapter = new RoundRecyclerAdapter(Rounds.this, completedRoundList);
                RoundsRecyclerView.setAdapter(roundRecyclerAdapter);
                roundRecyclerAdapter.notifyDataSetChanged();
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
