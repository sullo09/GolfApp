package com.example.sullo.golfapp;

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

public class DistanceMeasured extends AppCompatActivity {

    //	private	fields	of	the	class
    private TextView tv_lat;
    private TextView tv_long;
    private LocationManager lm;

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
            public void onLocationChanged(Location location) {
//	the	location of	the	device has changed so update the textviews to reflect this
                tv_lat.setText("Latutude " + location.getLatitude());
                tv_long.setText("Longitude: " + location.getLongitude());
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
        setContentView(R.layout.activity_main);

        tv_lat =	(TextView)	findViewById(R.id.tv_lat);
        tv_long =	(TextView)	findViewById(R.id.tv_long);
        lm =	(LocationManager)	getSystemService(Context.LOCATION_SERVICE);

//	add	in	the	location	listener
        addLocationListener();


    }
}
