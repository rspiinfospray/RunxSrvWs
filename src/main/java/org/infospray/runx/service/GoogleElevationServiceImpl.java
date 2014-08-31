package org.infospray.runx.service;

import java.util.ArrayList;
import java.util.List;

import org.infospray.runx.googleelevation.model.GoogleElevation;
import org.infospray.runx.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleElevationServiceImpl implements GoogleElevationService {
	
	
	@Autowired
	Environment env;
	
	
	/**
	 * Appel le WS google elevation	 
	 */
	@Override
	public List<GoogleElevation> getElevationByListCoord(List<Location> listCoord) {

		// comme l url rique d etre tres longue
		// on fait plusieurs appels

		String url = URL_GOOGLE_EVEVATION;
		
		RestTemplate template = new RestTemplate();
		
		List<GoogleElevation> listGoogleElevation = new ArrayList<GoogleElevation>();
		
		int sizeLimitation =  1000;


		for (Location coord : listCoord) {

			// si la taille de l url est inferieur a la limite on continu de concatener
			if(url.length() < sizeLimitation){
				url += coord.getLat() + "," + coord.getLng() + "|";					
			}else{
				url = url.substring(0, url.length() - 1);
				GoogleElevation  googleElevation = template.getForObject(url, GoogleElevation.class);
				listGoogleElevation.add(googleElevation);
				url = URL_GOOGLE_EVEVATION;
			}
		}


		return listGoogleElevation;
	}


	

}
