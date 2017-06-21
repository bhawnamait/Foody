package com.springapp.mvc;


import com.google.gson.Gson;
import com.restaurants.Restaurants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/restaurant")
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome() {
        return "newRestaurants";
    }

    @RequestMapping(value ="/index", method = RequestMethod.GET)
    public String addN(HttpServletRequest request,ModelMap model)
    {
        String y;
//        y="Sunder Vihar,New Delhi";
//
//        model.addAttribute("name", y);
        return "index";
    }
    @RequestMapping(value ="/store", method = RequestMethod.POST)
    public String latitudeAndLong(@RequestBody Restaurants search,ModelMap model)throws SQLException
    {

//i m adding this to see difference
        String y="sdv";
        Gson gson=new Gson();
        String json= gson.toJson(search);
        model.addAttribute("name", y);
        return "hello";
    }

    @RequestMapping(value ="/addNew", method = RequestMethod.POST)
    public String addNew(HttpServletRequest request,ModelMap model)throws SQLException
    {

        String name= request.getParameter("name");
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        float late = Float.parseFloat(lat);
        float lone =  Float.parseFloat(lon);

        jdbc.addNew(name,late,lone);
        model.addAttribute("name", name);
        return "hello";
    }
//fkltgk;gkgpotghvrhvrjr
    @RequestMapping(value ="/showImage", method = RequestMethod.POST)
    public String showImage()  {
        return "showImage";
    }
    @RequestMapping(value = "/LocalFeed",method = RequestMethod.GET)
    //ksddkss;ks
    public String jsonf(HttpServletRequest request,ModelMap model)
    {

        //String s= null;
        //mc,mv,mvlflfpfp
        //hjhkkmn,jkk
        ArrayList<Restaurants> s = new ArrayList<Restaurants>();
        Gson gson =new Gson();

        try {
             s = jdbc.findAllRest((float) 28.74839973449707, (float) 77.20600128173828);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String json= gson.toJson(s);
        model.addAttribute("object",s);
        return "localFeed";
       // return "hello";
    }

}