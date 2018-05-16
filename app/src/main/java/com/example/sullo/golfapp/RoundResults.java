package com.example.sullo.golfapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import Model.CompletedRound;

public class RoundResults extends AppCompatActivity {
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mUser;

    private ProgressDialog submitProgress;

    private EditText finalScore;
    private EditText finalScoreCourse;
    private EditText finalScoreName;
    private TextView finalScoreDateAdded;
    private Button saveRound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_results);


        mAuth = FirebaseAuth.getInstance().getInstance();
        mUser = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Rounds");
//        databaseReference = database.getReference().child("Rounds");
        databaseReference.keepSynced(true);

//progress wheel
        submitProgress = new ProgressDialog(this);

        finalScore = (EditText) findViewById(R.id.finalScore);
        finalScoreCourse = (EditText) findViewById(R.id.finalScoreCourse);
        finalScoreName = (EditText) findViewById(R.id.finalScoreName);
        finalScoreDateAdded = (TextView) findViewById(R.id.finalScoreDateAdded);
        saveRound = (Button) findViewById(R.id.saveRound);

        finalScoreCourse.setText("Courses: ");
        finalScoreName.setText("Name: ");
        finalScore.setText("Score: ");

        saveRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSubmitting();
            }
        });

    }
    private void startSubmitting(){
        submitProgress.setMessage("submitting round ...");
        submitProgress.show();


        String scoreCourseVal = finalScoreCourse.getText().toString().trim();
        String scoreNameVal = finalScoreName.getText().toString().trim();
        String scoreValueVal = finalScore.getText().toString().trim();
        //String scoreDateAddedVal = finalScore.getText().toString().trim();


        if(!TextUtils.isEmpty(scoreCourseVal) && !TextUtils.isEmpty(scoreNameVal) &&
                !TextUtils.isEmpty(scoreValueVal)){

            DatabaseReference newRound = databaseReference.push();

            Map<String, String> dataToSave = new HashMap<>();
            dataToSave.put("coursePlayed", scoreCourseVal);
            dataToSave.put("playerName", scoreNameVal);
            dataToSave.put("playerScore", scoreValueVal);
            dataToSave.put("timestamp", String.valueOf(System.currentTimeMillis()));
            dataToSave.put("userid", mUser.getUid());

            newRound.setValue(dataToSave);
            Toast.makeText(getApplicationContext(),"players round added",
                            Toast.LENGTH_LONG).show();

            submitProgress.dismiss();

            startActivity(new Intent(RoundResults.this,Rounds.class));
            finish();
        }
    }
}