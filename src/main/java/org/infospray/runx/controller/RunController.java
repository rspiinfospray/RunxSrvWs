package org.infospray.runx.controller;


import java.util.List;
import java.util.Map;

import org.infospray.runx.fit.model.Activity;
import org.infospray.runx.fit.model.DeviceFile;
import org.infospray.runx.fit.model.Settings;
import org.infospray.runx.fit.model.Sport;
import org.infospray.runx.fit.model.Totals;
import org.infospray.runx.fit.model.Weight;
import org.infospray.runx.model.Record;
import org.infospray.runx.rest.BuildRestResponse;
import org.infospray.runx.rest.ResponseBody;
import org.infospray.runx.service.ActivityService;
import org.infospray.runx.service.FitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("json/run")
public class RunController {

	@Autowired
	private FitService fitService;
	
	
	@Autowired
	private ActivityService activityService;


	/**
	 * activity
	 */
	
	@RequestMapping("/{user}/activity/{id}/")
	public ResponseEntity<ResponseBody<Activity>> getFitActivity(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivity(user,id));
	}
	
	
	@RequestMapping("/{user}/activity/{id}/fileId")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityFileId(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivityFileId(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/activity")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityActivity(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivityActivity(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/session")
	public ResponseEntity<ResponseBody<Map<String, Object>>> getFitActivitySession(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivitySession(user,id));
	}
	

	@RequestMapping("/{user}/activity/{id}/lap")
	public ResponseEntity<ResponseBody<List<Map<String, Object>>>> getFitActivityLap(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivityLap(user,id));
	}
	
	
	@RequestMapping("/{user}/activity/{id}/length")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityLength(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivityLength(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/record")
	public ResponseEntity<ResponseBody<List<Record>>> getFitActivityRecord(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(activityService.getListRecords());
	}
	
	@RequestMapping("/{user}/activity/{id}/event")
	public ResponseEntity<ResponseBody<List<Map<String, Object>>>> getFitActivityEvent(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivityEvent(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/deviceInfo")
	public ResponseEntity<ResponseBody<List<Map<String, Object>>>> getFitActivityDeviceInfo(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivityDeviceInfo(user,id));
	}
	
	@RequestMapping("/{user}/activity/{id}/hrv")
	public ResponseEntity<ResponseBody<Activity>> getFitActivityHrv(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitActivityHrv(user,id));
	}
	
	
	/**
	 * settings
	 */
	
	@RequestMapping("/{user}/settings/{id}/")
	public ResponseEntity<ResponseBody<Settings>> getFitSettings(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitSettings(user, id));
	}
	
	
	@RequestMapping("/{user}/settings/{id}/fileId")
	public ResponseEntity<ResponseBody<Settings>> getFitSettingsFileId(@PathVariable String user, @PathVariable long id){	
			
		return  BuildRestResponse.build(fitService.getFitSettingsFileId(user, id));
	}
	
	
	/**
	 * Sports
	 */
	
	
	@RequestMapping("/{user}/sports/{id}")
	public ResponseEntity<ResponseBody<Sport>> getFitSports(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSports(user));
	}
	
	
	@RequestMapping("/{user}/sports/{id}/fileId")
	public ResponseEntity<ResponseBody<Sport>> getFitSportsFileId(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSportsFileId(user));
	}
	
	@RequestMapping("/{user}/sports/{id}/zoneTarget")
	public ResponseEntity<ResponseBody<Sport>> getFitSportsZoneTarget(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSportsZoneTarget(user));
	}
	
	@RequestMapping("/{user}/sports/{id}/sport")
	public ResponseEntity<ResponseBody<Sport>> getFitSportsSport(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSportsSport(user));
	}
	
	@RequestMapping("/{user}/sports/{id}/hrZone")
	public ResponseEntity<ResponseBody<Sport>> getFitSportsHrZone(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSportsHrZone(user));
	}
	
	@RequestMapping("/{user}/sports/{id}/powerZone")
	public ResponseEntity<ResponseBody<Sport>> getFitSportsPowerZone(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSportsPowerZone(user));
	}
	
	@RequestMapping("/{user}/sports/{id}/metZone")
	public ResponseEntity<ResponseBody<Sport>> getFitSportsMetZone(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSportsMetZone(user));
	}
	
	@RequestMapping("/{user}/sports/{id}/speedZone")
	public ResponseEntity<ResponseBody<Sport>> getFitSportsSpeedZone(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitSportsSpeedZone(user));
	}
	
	/**
	 * Totals
	 */
	
	@RequestMapping("/{user}/totals/{id}")
	public ResponseEntity<ResponseBody<Totals>> getFitTotals(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitTotals(user));
	}
	
	@RequestMapping("/{user}/totals/{id}/fileId")
	public ResponseEntity<ResponseBody<Totals>> getFitTotalsFileId(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitTotalsFileId(user));
	}
	
	@RequestMapping("/{user}/totals/{id}/totals")
	public ResponseEntity<ResponseBody<Totals>> getFitTotalsTotals(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitTotalsTotals(user));
	}
	
	/**
	 * weight
	 */
	
	@RequestMapping("/{user}/weight/{id}")
	public ResponseEntity<ResponseBody<Weight>> getFitWeight(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitWeight(user));
	}
	
	
	@RequestMapping("/{user}/weight/{id}/fileId")
	public ResponseEntity<ResponseBody<Weight>> getFitWeightFileId(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitWeightFileId(user));
	}
	
	@RequestMapping("/{user}/weight/{id}/userProfile")
	public ResponseEntity<ResponseBody<Weight>> getFitWeightUserProfile(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitWeightUserProfile(user));
	}
	
	@RequestMapping("/{user}/weight/{id}/weightScale")
	public ResponseEntity<ResponseBody<Weight>> getFitWeightWeightSacale(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitWeightWeightSacale(user));
	}
	
	@RequestMapping("/{user}/weight/{id}/deviceInfos")
	public ResponseEntity<ResponseBody<Weight>> getFitWeightDeviceInfos(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitWeightDeviceInfos(user));
	}
	
	/**
	 * devices
	 */
	
	@RequestMapping("/{user}/devices/{id}")
	public ResponseEntity<ResponseBody<DeviceFile>> getFitDevices(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitDevices(user));
	}
	
	@RequestMapping("/{user}/devices/{id}/fileId")
	public ResponseEntity<ResponseBody<DeviceFile>> getFitDevicesFileId(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitDevicesFileId(user));
	}
	
	@RequestMapping("/{user}/devices/{id}/sofware")
	public ResponseEntity<ResponseBody<DeviceFile>> getFitDevicesSoftware(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitDevicesSoftware(user));
	}
	
	@RequestMapping("/{user}/devices/{id}/capabilities")
	public ResponseEntity<ResponseBody<DeviceFile>> getFitDevicesCapabilities(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitDevicesCapabilities(user));
	}
	
	@RequestMapping("/{user}/devices/{id}/fileCapabilities")
	public ResponseEntity<ResponseBody<DeviceFile>> getFitDevicesFileCapabilities(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitDevicesFileCapabilities(user));
	}
	
	@RequestMapping("/{user}/devices/{id}/mesgCapabilities")
	public ResponseEntity<ResponseBody<DeviceFile>> getFitDevicesMesgCapabilities(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitDevicesMesgCapabilities(user));
	}
	
	@RequestMapping("/{user}/devices/{id}/fieldCapabilities")
	public ResponseEntity<ResponseBody<DeviceFile>> getFitDevicesFieldCappabilities(@PathVariable String user){	
			
		return  BuildRestResponse.build(fitService.getFitDevicesFieldCappabilities(user));
	}


}
