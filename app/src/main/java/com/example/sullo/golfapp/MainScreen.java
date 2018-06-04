package com.example.sullo.golfapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainScreen extends AppCompatActivity {

    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adaptor;
//  private List<CourseItem> listItems;

    CardView newRoundCard, coursesCard, roundsCard, groupsCard, myProfileCard, distanceMeasureCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        mDatabase = FirebaseDatabase.getInstance();

        newRoundCard = (CardView) findViewById(R.id.newRoundCard);
        coursesCard = (CardView) findViewById(R.id.coursesCard);
        roundsCard = (CardView) findViewById(R.id.roundsCard);
        groupsCard = (CardView) findViewById(R.id.groupsCard);
        myProfileCard = (CardView) findViewById(R.id.myProfileCard);
        distanceMeasureCard = (CardView) findViewById(R.id.distanceMeasureCard);

        newRoundCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainScreen.this, "Clicked New Round", Toast.LENGTH_LONG).show();
                Intent startNewRound = new Intent(MainScreen.this, RoundCourses.class);
                startActivity(startNewRound);
            }
        });
        coursesCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainScreen.this, "Clicked RoundCourses", Toast.LENGTH_LONG).show();
                Intent courses = new Intent(MainScreen.this, MapsCourses.class);
                startActivity(courses);
            }
        });
        roundsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainScreen.this, "Clicked Rounds", Toast.LENGTH_LONG).show();
                Intent rounds = new Intent(MainScreen.this, Rounds.class);
                startActivity(rounds);
            }
        });
        groupsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainScreen.this, "Clicked Groups", Toast.LENGTH_LONG).show();
                Intent groups = new Intent(MainScreen.this, Groups.class);
                startActivity(groups);
            }
        });
        myProfileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainScreen.this, "Clicked My Profile", Toast.LENGTH_LONG).show();
                Intent myProfile = new Intent(MainScreen.this, MyProfile.class);
                startActivity(myProfile);
            }
        });
        distanceMeasureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainScreen.this, "Clicked Distance Measure", Toast.LENGTH_LONG).show();
                Intent YardageFinder = new Intent(MainScreen.this, YardageFinder.class);
                startActivity(YardageFinder);
            }
        });
    }

    //method to log you out and return to main login page
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mAuth != null && mUser != null){
            mAuth.signOut();
            Intent signout = new Intent(MainScreen.this, MainActivity.class);
            signout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(signout);
            //startActivity(new Intent(MainScreen.this, MainActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    //shows the log out button. menu is the page made for logout
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
