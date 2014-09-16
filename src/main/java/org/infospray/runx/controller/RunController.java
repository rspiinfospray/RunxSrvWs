package org.infospray.runx.controller;


import java.util.List;
import org.infospray.runx.model.Record;
import org.infospray.runx.rest.BuildRestResponse;
import org.infospray.runx.rest.ResponseBody;
import org.infospray.runx.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("json/run")
public class RunController {

	
	@Autowired
	private ActivityService activityService;


	/**
	 * activity
	 */
	
	@RequestMapping("/{user}/activity/{id}/record")
	public ResponseEntity<ResponseBody<List<Record>>> getFitActivityRecord(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(activityService.getListRecords(user, id));
	}
	
}
