package org.infospray.runx.controller;


import java.util.List;
import java.util.Map;

import org.infospray.runx.fit.model.Activity;
import org.infospray.runx.rest.BuildRestResponse;
import org.infospray.runx.rest.ResponseBody;
import org.infospray.runx.service.RawFitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("json/fit")
public class RawFitController {

	@Autowired
	private RawFitService rawFitService;


	/**
	 * activity
	 */
	
	@RequestMapping("/{user}/activity/{id}/")
	public ResponseEntity<ResponseBody<Activity>> getFitActivity(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getFullActivity(user,id));
	}
	
	
	@RequestMapping("/{user}/activity/{id}/fileId")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityFileId(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getActivityFileId(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/activity")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityActivity(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getActivity(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/session")
	public ResponseEntity<ResponseBody<Map<String, Object>>> getFitActivitySession(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getSession(user,id));
	}
	

	@RequestMapping("/{user}/activity/{id}/lap")
	public ResponseEntity<ResponseBody<List<Map<String, Object>>>> getFitActivityLap(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getMapLap(user,id));
	}
	
	
	@RequestMapping("/{user}/activity/{id}/length")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityLength(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getLength(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/record")
	public ResponseEntity<ResponseBody<List<Map<String, Object>>>> getFitActivityRecord(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getMapRecord(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/event")
	public ResponseEntity<ResponseBody<List<Map<String, Object>>>> getFitActivityEvent(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getEvent(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/deviceInfo")
	public ResponseEntity<ResponseBody<List<Map<String, Object>>>> getFitActivityDeviceInfo(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getDeviceInfo(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/hrv")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityHrv(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(rawFitService.getHrv(user,id));
	}
	
	
	

}
