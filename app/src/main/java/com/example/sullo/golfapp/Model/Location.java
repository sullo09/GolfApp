package com.example.sullo.golfapp.Model;

/**
 * Created by sullo on 01/04/2018.
 */

public class Location {
    private String latitude;
    private String longitude;

    //constructor
    public Location(String latitude, String longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }
    public Location(){
    }
}




//        Location loc1 = new Location("");
//        loc1.setLatitude(lat1);
//        loc1.setLongitude(lon1);
//
//        Location loc2 = new Location("");
//        loc2.setLatitude(lat2);
//        loc2.setLongitude(lon2);
//
//        float distanceInMeters = loc1.distanceTo(loc2);