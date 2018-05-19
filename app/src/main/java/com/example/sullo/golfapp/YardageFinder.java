package com.example.sullo.golfapp;

//used for the distance measurement

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import Adaptor.ShotAdapter;

public class YardageFinder extends AppCompatActivity{

//	private	fields	of	the	class
    private TextView result;
    private LocationManager lm;
    private ImageView imageStart;
    private Button buttonStart;
    private Button buttonEnd;
    private Button recordShot;

//first row of buttons
    private Button button4iron,button5iron,button6iron,button7iron,button8iron,button9iron;
//second row of buttons
    private Button buttonPW,buttonSW,buttonLW,button3R,button3W,buttonDriver;

    Location loc1 = new Location("");
    Location loc2 = new Location("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardage_finder);

        buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonEnd = (Button) findViewById(R.id.buttonEnd);
        recordShot = (Button) findViewById(R.id.recordShot);
        imageStart = (ImageView) findViewById(R.id.imageStart);
        result = (TextView) findViewById(R.id.result);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String club;


//  club buttons
        button4iron = (Button) findViewById(R.id.button4iron);
        button5iron = (Button) findViewById(R.id.button5iron);
        button6iron = (Button) findViewById(R.id.button6iron);
        button7iron = (Button) findViewById(R.id.button7iron);
        button8iron = (Button) findViewById(R.id.button8iron);
        button9iron = (Button) findViewById(R.id.button9iron);
        buttonPW = (Button) findViewById(R.id.buttonPW);
        buttonSW = (Button) findViewById(R.id.buttonSW);
        buttonLW = (Button) findViewById(R.id.buttonLW);
        button3R = (Button) findViewById(R.id.button3R);
        button3W = (Button) findViewById(R.id.button3W);
        buttonDriver = (Button) findViewById(R.id.buttonDriver);


        button4iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button4iron.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 4 Iron");
                Log.d("button4iron", "4 iron picked");
            }
        });
        button5iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button5iron.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 5 Iron");
            }
        });
        button6iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button6iron.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 6 Iron");
            }
        });
        button7iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button7iron.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 7 Iron");
            }
        });
        button8iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button8iron.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 8 Iron");
            }
        });
        button9iron.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button9iron.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 9 Iron");
            }
        });
        buttonPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPW.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: PW");
            }
        });
        buttonSW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonSW.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: SW");
            }
        });
        buttonLW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonLW.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: LW");
            }
        });
        button3R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3R.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 3 Rescue");
            }
        });
        button3W.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button3W.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: 3 Wood");
            }
        });
        buttonDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDriver.setBackgroundResource(R.color.clubPickedOff);
                result.setText("Club: Driver");
            }
        });
        recordShot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(YardageFinder.this, RecordedYardages.class);
                String record = String.valueOf(result);
                intent.putExtra("record", String.valueOf(record));
                startActivity(intent);
                Log.d("record", String.valueOf(record));

            }
        });

//	add in the location listener
        addLocationListener();

    }

 //	private	method that	will add a location	listener to	the	location manager
    private void addLocationListener() {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1, 5, new LocationListener() {
            @Override
            public void onLocationChanged(final Location location) {
// record location of first point
                    buttonStart.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            imageStart.setBackgroundResource(R.drawable.golfballend);
                            //imageStart.setImageResource(R.drawable.golfballend);
                            loc1.setLatitude(location.getLatitude());
                            loc1.setLongitude(location.getLongitude());
                            Log.d(String.valueOf(loc1), "Point one");
                        }
                    });
                    buttonEnd.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            imageStart.setBackgroundResource(R.drawable.golfballstart);
                            loc2.setLatitude(location.getLatitude());
                            loc2.setLongitude(location.getLongitude());
                            Log.d(String.valueOf(loc2), "Point two");

                            final float distanceInMeters = loc1.distanceTo(loc2);

                            double distanceInYards = distanceInMeters * 1.09361;
                            Log.d(String.valueOf(distanceInYards), "Point final");

                            result.setText(result.getText()+ "  Distance: " + Math.round(distanceInYards) + " Yards");

                        }
                    });
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
//	if there is	a last known location then set it on the textviews

            }

            @Override
            public void onProviderDisabled(String provider) {
//	if GPS has been	disabled then update the textviews to reflect this
            }
        });

    }
}

// https://stackoverflow.com/questions/22577075/calculating-the-distance-between-two-latitude-and-longitude-points-in-android
