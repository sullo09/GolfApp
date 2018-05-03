package com.example.sullo.golfapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayingRound extends AppCompatActivity {

    private Context context;

// id's from activity
    private TextView HoleNumber;
    private TextView HolePar;
    private TextView HoleIndex;
    private TextView teeWhite;
    private TextView teeYellow;
    private TextView teeRed;
    private Button green;
    private Button tips;
    private ImageView HoleImage;
    private ImageView nextHole;
    private ImageView previousHole;
    private EditText HoleScore;
    private EditText HolePutts;
    private TextView ScoreTotal;
    private TextView PuttsTotal;

//pop up for tips
    private AlertDialog.Builder dialogBuilderTips;
    private AlertDialog dialogTips;
    private TextView tipsHeading;
    private Button backToCard;

    private android.app.AlertDialog.Builder dialogBuilder;
    private android.app.AlertDialog dialog;
    private LayoutInflater inflater;
    private Button noButton;
    private Button yesButton;

    //variables to use details from json
    String par;
    String strokeIndex;
    String HolePicture;
    String whiteTees;
    String yellowTees;
    String redTees;
    String ScoreT;
    String GreenLocation;

    int NumberOfHole = 1;

    JSONArray CourseInfo = new JSONArray();

    // Declare all Postions to start at 0 so -1 to get actual hole;
    // This needs to be set to the number of holes (18 is max and most common)
    // This is not nessary but would make the app more memory efficient
    int[] scroesList = new int[18];
    int[] puttList = new int[18];
    int[] testList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_round);

        HoleNumber = (TextView) findViewById(R.id.HoleNumber);
        HolePar = (TextView) findViewById(R.id.HolePar);
        HoleIndex = (TextView) findViewById(R.id.HoleIndex);
        teeWhite = (TextView) findViewById(R.id.teeWhite);
        teeYellow = (TextView) findViewById(R.id.teeYellow);
        teeRed = (TextView) findViewById(R.id.teeRed);
        green = (Button) findViewById(R.id.green);
        tips = (Button) findViewById(R.id.tips);
        nextHole = (ImageView) findViewById(R.id.nextHole);
        previousHole = (ImageView) findViewById(R.id.previousHole);
        HoleScore = (EditText) findViewById(R.id.HoleScore);
        HolePutts = (EditText) findViewById(R.id.HolePutts);
        ScoreTotal = (TextView) findViewById(R.id.ScoreTotal);
        PuttsTotal = (TextView) findViewById(R.id.PuttsTotal);

        //Resources resources = getResources();
        HoleImage = (ImageView) findViewById(R.id.HoleImage);
        //HoleImage.setImageDrawable(resources.getDrawable(R.drawable.place_holder));


        tipsHeading = (TextView) findViewById(R.id.tipsHeading);
        //backToCard = (Button) findViewById(R.id.backToCard);


        // call json method
        get_json();


        // green view
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent showGreen = new Intent(PlayingRound.this, MapsCourses.class);
                startActivity(showGreen);
            }
        });

        nextHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToTheNextHole();
            }
        });
        previousHole.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backToPreviousHole();
            }
        });

// call the tips pop up
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupDialogTips();
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
            JSONObject courseDetails;

            for (int i = 0; i < jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);

                // equals, should be sent into method and hole number
                if (obj.getString("CourseID").equals("IR_OC_1")) {
                    courseDetails = obj.getJSONObject("CourseInformation");

                    Iterator x = courseDetails.keys();

                    while(x.hasNext()){
                        String key = (String) x.next();
                        CourseInfo.put(courseDetails.get(key));
                    }
                    testList = new int[CourseInfo.length()];
                    SetScreen();
                }
            }


        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }

    //sets the screen to according hole
    public void SetScreen (){
        try {
            JSONObject HoleInfo = CourseInfo.getJSONObject(NumberOfHole - 1);
            getAllHoleInformation(HoleInfo);
            HoleNumber.setText("HOLE " + NumberOfHole);
            //total score and putts calling method from hole
            // ScoreTotal is id of score total xml (HoleScore id on single score)
            //puttsTotal is id of putts total in xml (HolePutts id on single score)


            int sumScore = 0;
            int sumPutts = 0;

            // CourseInfo is the number of holes
            // This is set at the start when the json is parsed
            // This can't be hard cored as some course have only 9 holes
            for(int i=0; i < CourseInfo.length(); i++) {
                sumScore += scroesList[i];
                sumPutts += puttList[i];
            }

            ScoreTotal.setText("Total: " + Integer.toString(sumScore));
            PuttsTotal.setText("Total: " + Integer.toString(sumPutts));


        }catch (JSONException e){
            e.printStackTrace();
        }


    }

//returns all the hole information from json
    private void getAllHoleInformation(JSONObject holeInfo){
        try {
//return par from json
            par = holeInfo.getString("par");
            HolePar.setText("Par " + par);

//return index from json
            strokeIndex = holeInfo.getString("index");
            HoleIndex.setText("Index " + strokeIndex);

//return the tes's color and yardage of the hole from the json (start)
            whiteTees = holeInfo.getJSONObject("tees").getString("white");
            teeWhite.setText(whiteTees + " yards");
            teeWhite.setBackgroundResource(R.color.WhiteYards);

            yellowTees = holeInfo.getJSONObject("tees").getString("Yellow");
            teeYellow.setText(yellowTees + " yards");
            teeYellow.setBackgroundResource(R.color.yellowYards);

            redTees = holeInfo.getJSONObject("tees").getString("red");
            teeRed.setText(redTees + " yards");
            teeRed.setBackgroundResource(R.color.redYards);
//return the tes's color and yardage of the hole from the json (end)


//          GreenLocation = holeInfo.getString("");
//          "location":{"Latitude":53.213233,"Longitude":-6.142819},

//return tips of hole

//set holeScore text to score in arrrayList and list wise with putts
            HoleScore.setText(Integer.toString(scroesList[NumberOfHole-1]));
            HolePutts.setText(Integer.toString(puttList[NumberOfHole-1]));

//return the image of the hole from the json
            HolePicture = holeInfo.getString("imageLocation");
            HoleImage.setImageResource(getResources().getIdentifier(HolePicture, "drawable", this.getPackageName()));

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

//move to next hole on click
    private void moveToTheNextHole(){
        if(NumberOfHole < 18) {
            SetScores();
            NumberOfHole ++;
            SetScreen();
        }
    }

//go back to previous hole
    private void backToPreviousHole(){
        if(NumberOfHole > 1) {
            SetScores();
            NumberOfHole --;
            SetScreen();
        }
    }

    private void SetScores(){
        scroesList[NumberOfHole-1] = Integer.parseInt(HoleScore.getText().toString());
        puttList[NumberOfHole-1] = Integer.parseInt(HolePutts.getText().toString());
    }


//   test json end
//start pop up for tips
    private void createPopupDialogTips(){
        dialogBuilderTips = new AlertDialog.Builder(this);

        View view = getLayoutInflater().inflate(R.layout.pop_up_tips, null);

        dialogBuilderTips.setView(view);
        dialogTips = dialogBuilderTips.create();
        dialogTips.show();

        backToCard = (Button) findViewById(R.id.backToCard);

        backToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogTips.dismiss();
            }
        });
    }
    private void createPopupDialogDelete(){
        View view = View.inflate(null, R.layout.pop_up_tips, null);
        //dialogBuilder = new android.app.AlertDialog.Builder(view.getRootView().getContext());

        backToCard = (Button) view.findViewById(R.id.backToCard);

        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        backToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}