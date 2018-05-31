package com.example.sullo.golfapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyProfile extends AppCompatActivity {


    private EditText profileFirstName;
    private EditText ProfileEndHandicap;
    private EditText ProfileStartHandicap;
    private EditText profileLastName;
    private Button saveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        profileFirstName = (EditText) findViewById(R.id.profileFirstName);
        ProfileEndHandicap = (EditText) findViewById(R.id.ProfileEndHandicap);
        ProfileStartHandicap = (EditText) findViewById(R.id.ProfileStartHandicap);
        profileLastName = (EditText) findViewById(R.id.profileLastName);
        saveProfile = (Button) findViewById(R.id.saveProfile);

        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent BackToMain = new Intent(MyProfile.this, MainScreen.class);
                startActivity(BackToMain);
            }
        });
    }
}
