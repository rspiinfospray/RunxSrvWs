package org.infospray.runx.service;


import java.util.List;

import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.GeoJsonObject;
import org.geojson.LineString;
import org.geojson.LngLatAlt;
import org.geojson.Point;
import org.infospray.runx.model.Lap;
import org.infospray.runx.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GoogleMapServiceImpl implements GoogleMapService {


	@Autowired
	FitService fitService;
	
	@Autowired
	ActivityService activityService;


	@Override
	public GeoJsonObject getGeoJsonMap() {
	
		FeatureCollection featureCollection = new FeatureCollection();
		
		
		int cptLap = 0;
		for(Lap currentLap : activityService.getListLaps()){
			
			if(cptLap == 0){
				Feature feature = new Feature();
				Point point = new Point(Double.valueOf(currentLap.getStartPositionLongDegres()),Double.valueOf(currentLap.getStartPositionLatDegres()));			
				feature.setGeometry(point);					
				feature.setProperty("avgVitesse", currentLap.getAvgSpeed());	
				feature.setProperty("heure", currentLap.getBeginLapTime());						
				featureCollection.add(feature);		
			}
			
			Feature feature = new Feature();
			Point point = new Point(Double.valueOf(currentLap.getEndPositionLongDegres()),Double.valueOf(currentLap.getEndPositionLatDegres()));			
			feature.setGeometry(point);					
			feature.setProperty("avgVitesse", currentLap.getAvgSpeed());	
			feature.setProperty("heure", currentLap.getBeginLapTime());						
			featureCollection.add(feature);			
			
			cptLap++;
		}
		
		List<Record> listRecord = activityService.getListRecords();
		int sizeListRecord = listRecord.size();
		
		for(int cpt = 0 ; cpt != sizeListRecord; cpt++){
			
			if(cpt +1 != sizeListRecord){
				
				Record currentRecord = listRecord.get(cpt);
				Record nexRecord = listRecord.get(cpt + 1);

				
					Feature feature = new Feature();
					LngLatAlt lnglat1 = new LngLatAlt(Double.valueOf(currentRecord.getPositionLongDegres()),Double.valueOf(currentRecord.getPositionLatDegres()));
					LngLatAlt lnglat2 = new LngLatAlt(Double.valueOf(nexRecord.getPositionLongDegres()),Double.valueOf(nexRecord.getPositionLatDegres()));
					
					LineString line = new LineString(lnglat1,lnglat2);				
					feature.setGeometry(line);				
					feature.setProperty("speedIndice", currentRecord.getSpeedIndice());
					feature.setProperty("vitesse", currentRecord.getSpeed());
					feature.setProperty("heure", currentRecord.getHeure());
					featureCollection.add(feature);
		
			}	
		}
		
		return featureCollection;
	}
	
}
