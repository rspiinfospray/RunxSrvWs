package org.infospray.runx.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.infospray.runx.model.Lap;
import org.infospray.runx.model.LapSpeedFixing;
import org.infospray.runx.model.Record;
import org.infospray.runx.model.Session;
import org.infospray.runx.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {


	@Autowired
	FitService fitService;


	@Override
	public List<Lap> getListLaps() {
		List<Map<String, Object>> listMapLap = fitService.getFitActivityLap("", 1);

		List<Lap> listLaps = new ArrayList<Lap>();
		
		List<LapSpeedFixing> listLapSpeedFixing = this.generateFixedSpeedLap();

		int cpt = 0;
		for (Map<String, Object> mapLap : listMapLap) {
			Lap lap = new Lap();

			lap.setAvgSpeed(listLapSpeedFixing.get(cpt).getAvg());
			lap.setEndPositionLatDegres(((BigDecimal)mapLap.get("endPositionLatDegres")).doubleValue());			
			lap.setEndPositionLongDegres(((BigDecimal)mapLap.get("endPositionLongDegres")).doubleValue());			
			lap.setEventLibelle((String)mapLap.get("eventLibelle"));			
			lap.setEventTypeLibelle((String)mapLap.get("eventTypeLibelle"));
			lap.setEndLapTime(Utils.timestampToDateString(((Long)mapLap.get("timestamp")).intValue()));
			lap.setBeginLapTime(Utils.timestampToDateString(((Long)mapLap.get("startTime")).intValue()));
			lap.setIntensity((String)mapLap.get("intensity"));			
			lap.setMaxSpeed(listLapSpeedFixing.get(cpt).getMaxSpeed());
			lap.setMessageIndex(Integer.valueOf((String)mapLap.get("messageIndex")) + 1 );
			lap.setSport((String)mapLap.get("sport"));
			lap.setSportLibelle((String)mapLap.get("sportLibelle"));			
			lap.setStartPositionLatDegres(((BigDecimal)mapLap.get("startPositionLatDegres")).doubleValue());		
			lap.setStartPositionLongDegres(((BigDecimal)mapLap.get("startPositionLongDegres")).doubleValue());	
			lap.setTotalAscent((String)mapLap.get("totalAscent"));
			lap.setTotalCalories((String)mapLap.get("totalCalories"));
			lap.setTotalDescent((String)mapLap.get("totalDescent"));
			lap.setTotalDistance((String)mapLap.get("totalDistance"));
			lap.setTotalElapsedTime((String)mapLap.get("totalElapsedTime"));
			lap.setTotalTimerTime((String)mapLap.get("totalTimerTime"));

			listLaps.add(lap);
			cpt++;
		}

		return listLaps;
	}

	@Override
	public List<Record> getListRecords() {

		List<Map<String, Object>> listMapRecord = fitService.getFitActivityRecord("", 1);
		List<Record> listRecord = new ArrayList<Record>();
		Double previousSpeed = 0d;

		for (Map<String, Object> mapRecord : listMapRecord) {

			if(mapRecord.containsKey("positionLatDegres")){				
				Record record = new Record();

				record.setAltitude((String)mapRecord.get("altitude"));
				record.setDistance((String)mapRecord.get("distance"));
				record.setPositionLatDegres(((BigDecimal)mapRecord.get("positionLatDegres")).doubleValue());
				record.setPositionLongDegres(((BigDecimal)mapRecord.get("positionLongDegres")).doubleValue());
				Double dSpeed = Utils.mettreSecondeToKilometreHeure((String)mapRecord.get("speed"));				
				if(dSpeed.doubleValue() > Utils.MAX_SPEED_RUNNING_LIMIT){
					record.setSpeed(previousSpeed);
					record.setFixedSpeed(true);
				}else{
					record.setSpeed(dSpeed);
					previousSpeed = dSpeed;
				}
				record.setHeure(Utils.timestampToDateString(((Long)mapRecord.get("timestamp")).intValue()));
				record.setTimestamp((Long)mapRecord.get("timestamp"));

				listRecord.add(record);		
			}

		}


		this.generateSpeedIndice(listRecord);
		return listRecord;
	}
	
	
	public double getMaxSpeed(){

		List<Map<String, Object>> listMapRecord = fitService.getFitActivityRecord("", 1);
		double maxSpeed = 0d;

		for (Map<String, Object> mapRecord : listMapRecord) {
			Double dSpeed = Utils.mettreSecondeToKilometreHeure((String)mapRecord.get("speed"));
			if(dSpeed > maxSpeed &&  dSpeed <= Utils.MAX_SPEED_RUNNING_LIMIT){
				maxSpeed =  dSpeed;
			}
		}

		return maxSpeed;
	}
	
	public double getAvgSpeed(){
		
		double avgSpeed = 0d;
		
		List<Map<String, Object>> listMapRecord = fitService.getFitActivityRecord("", 1);
		int nbRecord = listMapRecord.size();
		int nbValidRecord = nbRecord;
		for (Map<String, Object> mapRecord : listMapRecord) {
			double dSpeed = Utils.mettreSecondeToKilometreHeure((String)mapRecord.get("speed"));
			if(dSpeed > Utils.MAX_SPEED_RUNNING_LIMIT){
				nbValidRecord--;
			}else{
				avgSpeed += dSpeed;
			}
		}
		
		avgSpeed = avgSpeed / nbValidRecord;
		
		return BigDecimal.valueOf(avgSpeed).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
	}
	


	public List<LapSpeedFixing> generateFixedSpeedLap(){
		
		List<Map<String, Object>> listMapLap = fitService.getFitActivityLap("", 1);

		List<LapSpeedFixing> listLapSpeedFixing =  new ArrayList<LapSpeedFixing>();
		
		for (Map<String,Object> mapLap : listMapLap) {
			LapSpeedFixing lapSpeedFixing  = new LapSpeedFixing();
			lapSpeedFixing.setStartLapTime((Long)mapLap.get("startTime"));
			lapSpeedFixing.setStopLapTime((Long)mapLap.get("timestamp"));
			listLapSpeedFixing.add(lapSpeedFixing);
		}
		
		double avgSpeed = 0d;
		double maxSpeed = 0d;
		
		List<Map<String, Object>> listMapRecord = fitService.getFitActivityRecord("", 1);		
		LapSpeedFixing currentLapFixed =  null;
		int recordCpt = 0;
		
		for (Map<String, Object> currentRecordMap : listMapRecord) {
			double dSpeed = Utils.mettreSecondeToKilometreHeure((String)currentRecordMap.get("speed"));
			if(dSpeed <= Utils.MAX_SPEED_RUNNING_LIMIT){
		
				LapSpeedFixing lapFixed = this.getLapByTimestamp(listLapSpeedFixing, (Long)currentRecordMap.get("timestamp"));
				if(currentLapFixed == null){
					currentLapFixed = lapFixed;
				}
				if(lapFixed == currentLapFixed){
					avgSpeed += dSpeed;
					recordCpt++;
					if(dSpeed > maxSpeed){
						maxSpeed = dSpeed;
					}
				}else{
					avgSpeed = avgSpeed / recordCpt;
					currentLapFixed.setAvg(BigDecimal.valueOf(avgSpeed).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
					currentLapFixed.setMaxSpeed(BigDecimal.valueOf(maxSpeed).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
					avgSpeed = 0d;
					maxSpeed = 0d;
					recordCpt = 0;
					currentLapFixed = lapFixed;
					avgSpeed += dSpeed;
					if(dSpeed > maxSpeed){
						maxSpeed = dSpeed;
					}
				}
			}
		}
		
		listLapSpeedFixing.get(listLapSpeedFixing.size() - 1).setAvg(BigDecimal.valueOf(avgSpeed / recordCpt).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
		listLapSpeedFixing.get(listLapSpeedFixing.size() - 1).setMaxSpeed(BigDecimal.valueOf(maxSpeed).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
		
		return listLapSpeedFixing;		
	}
	
	
	
	
	private LapSpeedFixing getLapByTimestamp(List<LapSpeedFixing> listLapSpeedFixing, long timestamp){
		
		for(LapSpeedFixing currentLap :  listLapSpeedFixing){
			if(timestamp >= currentLap.getStartLapTime()  
					&& timestamp < currentLap.getStopLapTime()){
				return currentLap;
			}		
		}
		return null;
	}

	private void generateSpeedIndice(List<Record> listRecord){

		double maxSpeed = this.getMaxSpeed();

		for (Record record : listRecord) {
			Double  speed = Double.valueOf(record.getSpeed());
			Double speedIndice =  (speed.doubleValue() / maxSpeed) * 100d;
			record.setSpeedIndice(speedIndice.intValue());
		}
	}

	@Override
	public Session getSession() {
		
		Map<String,Object> mapSession = fitService.getFitActivitySession("", 1);
		Session session = new Session();
		session.setAvgSpeed(Utils.mettreSecondeToKilometreHeure((String)mapSession.get("avgSpeed")));
		session.setEvent(Integer.valueOf((String)mapSession.get("event")));
		session.setEventLibelle((String)mapSession.get("eventLibelle"));
		session.setEventType(Integer.valueOf((String)mapSession.get("eventType")));
		session.setEventTypeLibelle((String)mapSession.get("eventTypeLibelle"));
		session.setFirstLapIndex(Integer.valueOf((String)mapSession.get("firstLapIndex")));
		session.setMaxSpeed(Utils.mettreSecondeToKilometreHeure((String)mapSession.get("maxSpeed")));
		session.setMessageIndex(Integer.valueOf((String)mapSession.get("messageIndex")));
		session.setNumLaps(Integer.valueOf((String)mapSession.get("numLaps")));
		session.setSport(Integer.valueOf((String)mapSession.get("sport")));
		session.setSportLibelle((String)mapSession.get("sportLibelle"));
		session.setStartActivityTime((Long)mapSession.get("startTime"));
		session.setStartPositionLongDegres(((BigDecimal)mapSession.get("startPositionLongDegres")).doubleValue());
		session.setStopActivityTime((Long)mapSession.get("timestamp"));
		session.setSubSport(Integer.valueOf((String)mapSession.get("subSport")));
		session.setTotalAscent(Integer.valueOf((String)mapSession.get("totalAscent")));
		session.setTotalCalories(Integer.valueOf((String)mapSession.get("totalCalories")));
		session.setTotalDescent(Integer.valueOf((String)mapSession.get("totalDescent")));
		session.setTotalDistance(Double.valueOf((String)mapSession.get("totalDistance")));
		session.setTotalElapsedTime(Double.valueOf((String)mapSession.get("totalElapsedTime")));
		session.setTotalTimerTime(Double.valueOf((String)mapSession.get("totalTimerTime")));
		
		return session;
	}

	
	
	

}


