package com.example.sullo.golfapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayRound extends AppCompatActivity {

    Button singles, foursomes, group;
    Button play;

//  pop up singles
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText name;
    private EditText handicap;
    private Button saveButton;

//  pop up for foursomes
    private AlertDialog.Builder dialogBuilderFoursomes;
    private AlertDialog dialogFoursomes;
    private EditText nameFoursomes1;
    private EditText handicapFoursomes1;
    private EditText nameFoursomes2;
    private EditText handicapFoursomes2;
    private Button saveButtonFoursomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_round);

        singles = (Button) findViewById(R.id.singles);
        foursomes = (Button) findViewById(R.id.foursomes);
        group = (Button) findViewById(R.id.foursomes);
        play = (Button) findViewById(R.id.play);

        singles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupDialogSingles();
            }
        });
        foursomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupDialogFoursomes();
            }
        });


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playRound = new Intent(PlayRound.this, PlayingRound.class);
                startActivity(playRound);
            }
        });
    }
//singles pop up
    private void createPopupDialogSingles(){
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.pop_up_details, null);
        name = (EditText) view.findViewById(R.id.name);
        handicap = (EditText) view.findViewById(R.id.handicap);
        saveButton = (Button) view.findViewById(R.id.saveButton);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save details and display on screen playRound

            }
        });
    }

//foursomes pop up
    private void createPopupDialogFoursomes(){
        dialogBuilderFoursomes = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.pop_up_details_foursome, null);
        nameFoursomes1 = (EditText) view.findViewById(R.id.nameFoursomes1);
        handicapFoursomes1 = (EditText) view.findViewById(R.id.handicapFoursomes1);
        nameFoursomes2 = (EditText) view.findViewById(R.id.nameFoursomes2);
        handicapFoursomes2 = (EditText) view.findViewById(R.id.handicapFoursomes2);
        saveButtonFoursomes = (Button) view.findViewById(R.id.saveButtonFoursomes);

        dialogBuilderFoursomes.setView(view);
        dialogFoursomes = dialogBuilderFoursomes.create();
        dialogFoursomes.show();

        saveButtonFoursomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save details and display on screen playRound
            }
        });

    }
}