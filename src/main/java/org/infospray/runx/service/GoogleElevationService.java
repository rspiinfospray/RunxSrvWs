package org.infospray.runx.service;

import java.util.List;

import org.infospray.runx.googleelevation.model.GoogleElevation;
import org.infospray.runx.model.Location;

public interface GoogleElevationService {
	
	public static String URL_GOOGLE_EVEVATION = "http://maps.googleapis.com/maps/api/elevation/json?locations=";
	
	
	public List<GoogleElevation> getElevationByListCoord(List<Location> listCoord);

}
