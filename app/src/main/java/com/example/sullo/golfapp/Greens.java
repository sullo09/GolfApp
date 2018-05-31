package com.example.sullo.golfapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Greens extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final LatLng Hole1 = new LatLng(53.213240, -6.142805);
    private static final LatLng Hole2 = new LatLng(53.211202, -6.142965);
    private static final LatLng Hole3 = new LatLng(53.213019, -6.145187);
    private static final LatLng Hole4  = new LatLng(53.216060, -6.138690);
    private static final LatLng Hole5 = new LatLng(53.213138, -6.146382);
    private static final LatLng Hole6 = new LatLng(53.215810, -6.143974);
    private static final LatLng Hole7 = new LatLng(53.217761, -6.140806);
    private static final LatLng Hole8  = new LatLng(53.218539, -6.140921);
    private static final LatLng Hole9 = new LatLng(53.216345, -6.139269);
    private static final LatLng Hole10 = new LatLng(53.218406, -6.135300);
    private static final LatLng Hole11 = new LatLng(53.216364, -6.136912);
    private static final LatLng Hole12  = new LatLng(53.216017, -6.135012);
    private static final LatLng Hole13 = new LatLng(53.210498, -6.137583);
    private static final LatLng Hole14 = new LatLng(53.210991, -6.141406);
    private static final LatLng Hole15 = new LatLng(53.213265, -6.137166);
    private static final LatLng Hole16  = new LatLng(53.211565, -6.141799);
    private static final LatLng Hole17 = new LatLng(53.212180, -6.142399);
    private static final LatLng Hole18 = new LatLng(53.215253, -6.137393);


    private Marker hole1;
    private Marker hole2;
    private Marker hole3;
    private Marker hole4;
    private Marker hole5;
    private Marker hole6;
    private Marker hole7;
    private Marker hole8;
    private Marker hole9;
    private Marker hole10;
    private Marker hole11;
    private Marker hole12;
    private Marker hole13;
    private Marker hole14;
    private Marker hole15;
    private Marker hole16;
    private Marker hole17;
    private Marker hole18;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greens);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<Marker> golfHoles = new ArrayList<>();

        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        hole1 = mMap.addMarker(new MarkerOptions()
                .position(Hole1).title("1st Green"));
        hole1.setTag(0);
        golfHoles.add(hole1);

        hole2 = mMap.addMarker(new MarkerOptions()
                .position(Hole2).title("2nd Green"));
        hole2.setTag(1);
        golfHoles.add(hole2);

        hole3 = mMap.addMarker(new MarkerOptions()
                .position(Hole3).title("3rd Green"));
        hole3.setTag(2);
        golfHoles.add(hole3);

        hole4 = mMap.addMarker(new MarkerOptions()
                .position(Hole4).title("4th Green"));
        hole4.setTag(3);
        golfHoles.add(hole4);

        hole5 = mMap.addMarker(new MarkerOptions()
                .position(Hole5).title("5th Green"));
        hole5.setTag(4);
        golfHoles.add(hole5);

        hole6 = mMap.addMarker(new MarkerOptions()
                .position(Hole6).title("6th Green"));
        hole6.setTag(5);
        golfHoles.add(hole6);

        hole7 = mMap.addMarker(new MarkerOptions()
                .position(Hole7).title("7th Green"));
        hole7.setTag(6);
        golfHoles.add(hole7);

        hole8 = mMap.addMarker(new MarkerOptions()
                .position(Hole8).title("8th Green"));
        hole8.setTag(7);
        golfHoles.add(hole8);

        hole9 = mMap.addMarker(new MarkerOptions()
                .position(Hole9).title("9th Green"));
        hole9.setTag(8);
        golfHoles.add(hole9);

        hole10 = mMap.addMarker(new MarkerOptions()
                .position(Hole10).title("10th Green"));
        hole10.setTag(9);
        golfHoles.add(hole10);

        hole11 = mMap.addMarker(new MarkerOptions()
                .position(Hole11).title("11th Green"));
        hole11.setTag(10);
        golfHoles.add(hole11);

        hole12 = mMap.addMarker(new MarkerOptions()
                .position(Hole12).title("12th Green"));
        hole12.setTag(11);
        golfHoles.add(hole12);

        hole13 = mMap.addMarker(new MarkerOptions()
                .position(Hole13).title("13th Green"));
        hole13.setTag(12);
        golfHoles.add(hole13);

        hole14 = mMap.addMarker(new MarkerOptions()
                .position(Hole14).title("14th Green"));
        hole14.setTag(13);
        golfHoles.add(hole14);

        hole15 = mMap.addMarker(new MarkerOptions()
                .position(Hole15).title("15th Green"));
        hole15.setTag(14);
        golfHoles.add(hole15);

        hole16 = mMap.addMarker(new MarkerOptions()
                .position(Hole16).title("16th Green"));
        hole16.setTag(15);
        golfHoles.add(hole16);

        hole17 = mMap.addMarker(new MarkerOptions()
                .position(Hole17).title("17th Green"));
        hole17.setTag(16);
        golfHoles.add(hole17);

        hole18 = mMap.addMarker(new MarkerOptions()
                .position(Hole18).title("18th Green"));
        hole18.setTag(17);
        golfHoles.add(hole18);


        for (Marker marker : golfHoles){
            Log.d("Marker", marker.getTitle());

            LatLng latLng = new LatLng(marker.getPosition().latitude,marker.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        }


        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

//        LatLng secondGreen = new LatLng(53.213233, -6.142819);
//        mMap.addMarker(new MarkerOptions().position(secondGreen).title("Hole 2")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(secondGreen, 16));
    }
}
