package com.example.sullo.golfapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MyProfile extends AppCompatActivity {

//shared preferences
    private SharedPreferences mPreferances;
    private SharedPreferences.Editor mEditor;


    private EditText profileFirstName;
    private EditText profileEndHandicap;
    private EditText profileStartHandicap;
    private EditText profileLastName;
    private Button saveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        mPreferances = getPreferences(MODE_PRIVATE);

        profileFirstName = (EditText) findViewById(R.id.profileFirstName);
        profileEndHandicap = (EditText) findViewById(R.id.ProfileEndHandicap);
        profileStartHandicap = (EditText) findViewById(R.id.ProfileStartHandicap);
        profileLastName = (EditText) findViewById(R.id.profileLastName);
        saveProfile = (Button) findViewById(R.id.saveProfile);

        readPreferences();

//saving info with shared preferences


        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = profileFirstName.getText().toString();
                String lastName = profileLastName.getText().toString();
                String startHand = profileStartHandicap.getText().toString();
                String endHand = profileEndHandicap.getText().toString();

                SharedPreferences.Editor editor = mPreferances.edit();
                editor.putString("keyfname", firstName);
                editor.putString("keysurname", lastName);
                editor.putString("keystartH", startHand);
                editor.putString("keyendH", endHand);
                editor.commit();

                Intent BackToMain = new Intent(MyProfile.this, MainScreen.class);
                startActivity(BackToMain);
            }
        });
    }

// read and display data
    public void readPreferences(){
        String sname = mPreferances.getString("keyfname", "");
        profileFirstName.setText(sname);
        String ssurname = mPreferances.getString("keysurname", "");
        profileLastName.setText(ssurname);
        String sstart = mPreferances.getString("keystartH", "");
        profileStartHandicap.setText(sstart);
        String send = mPreferances.getString("keyendH", "");
        profileEndHandicap.setText(send);
    }

}
