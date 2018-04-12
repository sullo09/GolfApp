package com.example.sullo.golfapp;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PlayingRound extends AppCompatActivity {

    private TextView HolePar;
    private TextView HoleIndex;
    private TextView teeWhite;
    private TextView teeYellow;
    private TextView teeRed;
    private Button green;
    private Button tips;

//pop up for tips
    private AlertDialog.Builder dialogBuilderTips;
    private AlertDialog dialogTips;
    private TextView tipsHeading;
    private Button backToCard;


    String par;
    String strokeIndex;
    String whiteTees;
    String yellowTees;
    String redTees;


    ArrayList<String> numberlist = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_round);

        HolePar = (TextView) findViewById(R.id.HolePar);
        HoleIndex = (TextView) findViewById(R.id.HoleIndex);
        teeWhite = (TextView) findViewById(R.id.teeWhite);
        teeYellow = (TextView) findViewById(R.id.teeYellow);
        teeRed = (TextView) findViewById(R.id.teeRed);
        green = (Button) findViewById(R.id.green);
        tips = (Button) findViewById(R.id.tips);


// call json method
        get_json();

// call the tips pop up
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupDialogTips();
            }
        });

// green view
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playRound = new Intent(PlayingRound.this, MapsCourses.class);
                startActivity(playRound);
            }
        });

    }
// test json start
    public void get_json(){
        String json;
        try{
            InputStream is = getAssets().open("customTees.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
            JSONArray jsonArray = new JSONArray(json);



            for (int i = 0; i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                //if (obj.getString("city").equals("isb")){

                   // numberlist.add(obj.getString("number"));
                if (obj.getString("tee_id").equals("OC_1_01")) {
                    par = obj.getString("hole1_par");
                    strokeIndex = obj.getString("hole1_handicap");

                    HolePar.setText("Par " + par);
                    HoleIndex.setText("Index " + strokeIndex);
                }
            }
            for (int i = 0; i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.getString("tee_color").equals("White")) {
                    whiteTees = obj.getString("hole1");
                    teeWhite.setText(whiteTees + " yards");
                    teeWhite.setBackgroundResource(R.color.WhiteYards);
                }
            }
            for (int i = 0; i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.getString("tee_color").equals("Yellow")) {
                    yellowTees = obj.getString("hole1");
                    teeYellow.setText(yellowTees + " yards");
                    teeYellow.setBackgroundResource(R.color.yellowYards);
                }
            }
            for (int i = 0; i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                if (obj.getString("tee_color").equals("Red")) {
                    redTees = obj.getString("hole1");
                    teeRed.setText(redTees + " yards");
                    teeRed.setBackgroundResource(R.color.redYards);
                }
            }


            //Toast.makeText(getApplicationContext(),numberlist.toString(),Toast.LENGTH_LONG).show();

        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
//   test json end
//start pop up for tips
    private void createPopupDialogTips(){
        dialogBuilderTips = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.pop_up_tips, null);

        tipsHeading = (TextView) findViewById(R.id.tipsHeading);
        backToCard = (Button) findViewById(R.id.backToCard);

        dialogBuilderTips.setView(view);
        dialogTips = dialogBuilderTips.create();
        dialogTips.show();
    }
}
