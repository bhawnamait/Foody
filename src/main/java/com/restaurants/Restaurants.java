package com.restaurants;
/**
 * Created by bhawna on 19/04/16.
 */
public class Restaurants {
    private String name;
    private float lat;
    private float lon;
    private float dist;

    public Restaurants( String name,float lat,float lon ,float dist){
        this.name=name;
        this.lat=lat;
        this.lon=lon;
        this.dist=dist;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setDist(float dist) {
        this.dist = dist;
    }

    public float getDist() {
        return dist;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
