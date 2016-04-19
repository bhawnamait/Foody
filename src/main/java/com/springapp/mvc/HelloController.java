package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/restaurant")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome() {
		return "newRestaurants";
	}
    @RequestMapping(value ="/addNew", method = RequestMethod.POST)
    public String addNew(HttpServletRequest request,ModelMap model)
    {
        String name= request.getParameter("name");
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        float late = Float.parseFloat(lat);
        float lone =  Float.parseFloat(lon);
        model.addAttribute("name", name);
        jdbc.addNew(name,late,lone);
     return "hello";
    }
}