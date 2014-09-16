package org.infospray.runx.controller;


import org.infospray.runx.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {

	@Autowired
	ActivityService activityService;

	@RequestMapping("/map/")
	String getMap(Model model){
		
		String user = "Amne";
		
		long id = 20140824101122l;
		
		model.addAttribute("fileId", String.valueOf(id));
		model.addAttribute("startLocation", activityService.getFirstLocation(user, id));	
		model.addAttribute("avgSpeed", activityService.getAvgSpeed(user, id));	
		model.addAttribute("maxSpeed", activityService.getMaxSpeed(user, id));
		model.addAttribute("distanceTotal", activityService.getSession(user, id).getTotalDistance());
		model.addAttribute("caloriesTotal", activityService.getSession(user, id).getTotalCalories());
		model.addAttribute("laps", activityService.getListLaps(user, id));		
		return "geo";
	}

}
