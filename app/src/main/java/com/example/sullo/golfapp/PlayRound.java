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

//    for pop up
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText name;
    private EditText handicap;
    private Button saveByutton;

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
                createPopupDialog();
            }
        });
        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupDialog();
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

    private void createPopupDialog(){
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.pop_up_details, null);
        name = (EditText) view.findViewById(R.id.name);
        handicap = (EditText) view.findViewById(R.id.handicap);
        saveByutton = (Button) view.findViewById(R.id.saveButton);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        saveByutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//          save details and display on screen

            }
        });
    }
}
