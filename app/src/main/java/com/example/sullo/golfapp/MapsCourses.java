package com.example.sullo.golfapp;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsCourses extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final LatLng OldConnaGC = new LatLng(53.215558,-6.1402148);
    private static final LatLng BrayGC = new LatLng(53.182101,-6.091881);
    private static final LatLng DunLaoghaireGC = new LatLng(53.211174,-6.1630377);
    private static final LatLng WoodbrookGC  = new LatLng(53.216807,-6.1140187);


    private Marker oldConnaGC;
    private Marker brayGC;
    private Marker dunLaoghaireGC;
    private Marker woodbrookGC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_courses);
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

        List<Marker> markerList = new ArrayList<>();

//        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        oldConnaGC = mMap.addMarker(new MarkerOptions()
        .position(OldConnaGC).title("Old Conna Golf Club"));
        oldConnaGC.setTag(0);
        markerList.add(oldConnaGC);

        brayGC = mMap.addMarker(new MarkerOptions()
        .position(BrayGC).title("Bray Golf Club"));
        brayGC.setTag(0);
        markerList.add(brayGC);

        dunLaoghaireGC = mMap.addMarker(new MarkerOptions()
                .position(DunLaoghaireGC).title("Dun Laoghaire Golf Club"));
        dunLaoghaireGC.setTag(0);
        markerList.add(dunLaoghaireGC);

//        woodbrookGC = mMap.addMarker(new MarkerOptions()
//                .position(WoodbrookGC).title("Woodbrook Golf Club"));
//        woodbrookGC.setTag(0);
//        markerList.add(woodbrookGC);

        for (Marker marker : markerList){
            Log.d("Marker", marker.getTitle());

            LatLng latLng = new LatLng(marker.getPosition().latitude,marker.getPosition().longitude);
            mMap.addMarker(new MarkerOptions().position(latLng));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
        }

//         LatLng secondGreen = new LatLng(53.213233, -6.142819);
//        // LatLng thirdGreen = new LatLng(53.213233, -6.142819);
//        // LatLng forthGreen = new LatLng(53.213233, -6.142819);
//
//        mMap.addMarker(new MarkerOptions().position(secondGreen).title("OldConna1")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(secondGreen, 13));
    }
}
