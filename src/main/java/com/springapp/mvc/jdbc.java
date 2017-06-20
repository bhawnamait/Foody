package com.springapp.mvc;

import com.google.gson.Gson;
import com.restaurants.Restaurants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.restaurants.findDist;
/**
 * Created by bhawna on 19/04/16.
 */
public class jdbc {


    static final String DB_URL = "jdbc:mysql://localhost:3306/UserDB";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "poi000poi";
    static Connection conn = null;

    static {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

//                conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    public static void addNew(String name,float lat,float lon) {
        PreparedStatement st = null;

       try {
            //STEP 3: Open a connection

            st = conn.prepareStatement("insert into Restaurant(Name,Lat,Lon) values (?,?,?);");
            //now you bind the data to your parameters
            st.setString(1, name);
            st.setFloat(2, lat);
            st.setFloat(3, lon);
            st.executeUpdate();
           System.out.print("added");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(st!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }
    private static Connection getDBConnection() {

        Connection conn = null;

        try {

            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection

        } catch (ClassNotFoundException e) {

            System.out.println(e.getMessage());

        }

        try {

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            return conn;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return conn;

    }
    public static ArrayList<Restaurants> AddRest()
    {
        Connection conn=null;
        PreparedStatement st = null;


            ArrayList<Restaurants> arrayList = new ArrayList<Restaurants>();
        System.out.println("find nearest restaurant...");
        Statement statement = null;
        try {
            conn=getDBConnection();
            String selectTableSQL = "SELECT Name,Lat,Lon from Restaurant";
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {

                String lat2 = rs.getString("Lat");
                String lon2 = rs.getString("Lon");
                String name = rs.getString("Name");
                float latf = Float.parseFloat(lat2);
                float lonf = Float.parseFloat(lon2);
                float dist = -1;
                Restaurants res = new Restaurants(name, latf, lonf, dist);
                arrayList.add(res);
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    conn.close();
            } catch (SQLException ignored) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }

        Gson gson =new Gson();
        String jsonCartList = gson.toJson(arrayList);
// print your generated json
        System.out.println("jsonList: " + jsonCartList);

       // return jsonCartList;
        return arrayList;
    }
    public static  ArrayList<Restaurants>  findAllRest(float Lat, float Lon) throws SQLException, ClassNotFoundException {

        ArrayList<Restaurants> arrayList = new ArrayList<Restaurants>();
        System.out.println("find nearest restaurant...");
        Connection conn=null;
        Statement statement = null;
        try {
            String selectTableSQL = "SELECT Name,Lat,Lon from Restaurant";
            conn=getDBConnection();
            statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {

                String lat2 = rs.getString("Lat");
                String lon2 = rs.getString("Lon");
                String name = rs.getString("Name");
                float latf = Float.parseFloat(lat2);
                float lonf = Float.parseFloat(lon2);
                float dist = -1;
                Restaurants res = new Restaurants(name, latf, lonf, dist);
                arrayList.add(res);
            }
        }
            catch(SQLException e) {
                e.printStackTrace();
            }finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    conn.close();
            } catch (SQLException ignored) {
            }// do nothing
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }

        return findDist.distance(arrayList, Lat, Lon);
    }
}
