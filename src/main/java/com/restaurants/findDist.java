package com.restaurants;

/**
 * Created by bhawna on 19/04/16.
 */
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by suruchi on 19/4/16.
 */
public class findDist{


    public static ArrayList<Restaurants> distance(ArrayList<Restaurants> arrayList, float lat2, float lon2) {

        for(int i = 0; i <arrayList.size(); i++) {
            Restaurants res=arrayList.get(i);
            String unit = "K";
            System.out.print("lat1");
            float lat1 = res.getLat();
            float lon1 = res.getLon();
            float theta = lon1 - lon2;
            float dist = (float) (Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta)));
            dist = (float) Math.acos(dist);
            dist = rad2deg(dist);
            dist = (float) (dist * 60 * 1.1515);
            if (unit == "K") {
                dist =(float) (dist * 1.609344);
            } else if (unit == "N") {
                dist = (float) (dist * 0.8684);
            }
            arrayList.get(i).setDist(dist);

        }
        Collections.sort(arrayList, new Comparator<Restaurants>(){
            public int compare(Restaurants o1, Restaurants o2){
                if(o1.getDist() == o2.getDist())
                    return 0;
                return o1.getDist() < o2.getDist() ? -1 : 1;
            }
        });
       Gson gson =new Gson();
        String jsonCartList = gson.toJson(arrayList);
// print your generated json
        System.out.println("jsonList: " + jsonCartList+arrayList.size());

       // return jsonCartList;
       return arrayList;
    }

//vk;vk;kbf

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*:: This function converts decimal degrees to radians :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static float deg2rad(float deg) {
        return (float) (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
/*:: This function converts radians to decimal degrees :*/
/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private static float rad2deg(float rad) {
        return (float) (rad * 180 / Math.PI);
    }
}