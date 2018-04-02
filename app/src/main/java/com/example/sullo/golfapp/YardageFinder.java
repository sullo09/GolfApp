package com.example.sullo.golfapp;

//used for the distance measurement

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class YardageFinder extends AppCompatActivity {

    //	private	fields	of	the	class
    private TextView tv_lat;
    private TextView tv_long;
    private Button firstPoint;
    private TextView tv_lat2;
    private TextView tv_long2;
    private Button secondPoint;
    private TextView result;
    private LocationManager lm;



    Float lat1 = null;
    Float long1 = null;
    Float lat2 = null;
    Float long2 = null;

    Float finalLat = null;
    Float finalLong = null;





    Location loc1 = new Location("");
    Location loc2 = new Location("");

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
//	the	location of	the	device has changed so update the textviews to reflect this

//                Location loc1 = new Location("");
//                loc1.setLatitude(lat1);
//                loc1.setLongitude(long1);
//
//                Location loc2 = new Location("");
//                loc2.setLatitude(lat2);
//                loc2.setLongitude(long2);
//
//                final float distanceInMeters = loc1.distanceTo(loc2);


                firstPoint.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        tv_lat.setText("" + location.getLatitude());
                        tv_long.setText("" + location.getLongitude());

                        String str = tv_lat.getText().toString();
                        String str1 = tv_long.getText().toString();
                        lat1 = Float.parseFloat(str);
                        long1 = Float.parseFloat(str1);

                    }
                });

                secondPoint.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_lat2.setText("" + location.getLatitude());
                        tv_long2.setText("" + location.getLongitude());

                        String str2 = tv_lat.getText().toString();
                        String str3 = tv_long.getText().toString();
                        lat2 = Float.parseFloat(str2);
                        long2 = Float.parseFloat(str3);

                        finalLat = lat2-lat1;
                        finalLong = long2 - long1;

                        result.setText(""+ finalLat);
                        result.setText(""+ finalLong);

                    }
                });

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
//	if there is	a last known location then set it on the textviews
                if (provider == LocationManager.GPS_PROVIDER) {
                    Location l = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    if (l != null) {
                        tv_lat.setText("Latitude:	" + l.getLatitude());
                        tv_long.setText("Longitude:	" + l.getLongitude());
                    }
                }
            }

            @Override
            public void onProviderDisabled(String provider) {
//	if GPS has been	disabled then update the textviews to reflect this
                if (provider == LocationManager.GPS_PROVIDER) {
                    tv_lat.setText(R.string.tv_lat_text);
                    tv_long.setText(R.string.tv_long_text);
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yardage_finder);

        tv_lat = (TextView) findViewById(R.id.tv_lat);
        tv_long = (TextView) findViewById(R.id.tv_long);
        firstPoint = (Button) findViewById(R.id.firstPoint);
        tv_lat2 = (TextView) findViewById(R.id.tv_lat2);
        tv_long2 = (TextView) findViewById(R.id.tv_long2);
        secondPoint = (Button) findViewById(R.id.secondPoint);
        result = (TextView) findViewById(R.id.result);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

//	add in the location listener
        addLocationListener();

    }
}

// https://stackoverflow.com/questions/22577075/calculating-the-distance-between-two-latitude-and-longitude-points-in-android




