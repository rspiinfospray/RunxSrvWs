package org.infospray.runx.controller;

import org.geojson.GeoJsonObject;
import org.infospray.runx.service.GoogleMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("json/googlemap")
public class MapController {
	
	
	@Autowired
	GoogleMapService gMapService;
	
	@RequestMapping("/{user}/activity/{id}/")
	GeoJsonObject getJsonCoordMap(){
		
		return gMapService.getGeoJsonMap();
	}

}
