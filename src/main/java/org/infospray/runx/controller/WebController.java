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
		
		model.addAttribute("avgSpeed", activityService.getAvgSpeed());	
		model.addAttribute("maxSpeed", activityService.getMaxSpeed());
		model.addAttribute("distanceTotal", activityService.getSession().getTotalDistance());
		model.addAttribute("caloriesTotal", activityService.getSession().getTotalCalories());
		model.addAttribute("laps", activityService.getListLaps());		
		return "geo";
	}

}
