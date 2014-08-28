package org.infospray.runx.fit;

import java.math.BigDecimal;
import java.util.Map;

import com.garmin.fit.Event;
import com.garmin.fit.EventType;
import com.garmin.fit.Field;
import com.garmin.fit.Mesg;
import com.garmin.fit.Sport;

public class FitUtils {


	public static Long DEFAULT_ADD_TIMESTAMP =  631065600l;
	
	public static String toCamelCase(String s) {
		String result = "";
		String[] tokens = s.split("_"); // or whatever the divider is
		for (int i = 0, L = tokens.length; i<L; i++) {
			String token = tokens[i];
			if (i==0) result = token.toLowerCase();
			else
				result += token.substring(0, 1).toUpperCase() +
				token.substring(1, token.length()).toLowerCase();
		}
		return result;
	}
	
	
	public static BigDecimal convertSemiCircleToDegres(Integer semicircle){
		
		BigDecimal bSemicircle =  new BigDecimal(semicircle);
		BigDecimal degres;
		
		double pow = Math.pow(2, 31);
		double div = 180.0d / pow; 
		BigDecimal bDiv = new BigDecimal(div);
		degres = bSemicircle.multiply(bDiv);

		return degres;
	}
	
	
	public static String getFieldValue(Mesg mesg, Field field){
		int subFieldIndex = mesg.GetActiveSubFieldIndex(field.getNum());
		
		return field.getStringValue(0, subFieldIndex);
	}
	
	public static String getFieldName(Mesg mesg, Field field){
		int subFieldIndex = mesg.GetActiveSubFieldIndex(field.getNum());
		return field.getName(subFieldIndex);
	}
	
	
	public static boolean formatterTime(String cmlFieldName, String value, Map<String,Object> data){
		
		if(cmlFieldName.equals("startTime") || 
				cmlFieldName.equals("timestamp") || 
				cmlFieldName.equals("timeCreated")){
			data.put(cmlFieldName, Long.valueOf(value) + FitUtils.DEFAULT_ADD_TIMESTAMP);
			
			return true;
		}
		return false;
	}
	
	public static void formatterGeo(String cmlFieldName, String value, Map<String,Object> data){
		
		if(cmlFieldName.equals("startPositionLat")
				|| cmlFieldName.equals("endPositionLat")
				|| cmlFieldName.equals("startPositionLong")
				|| cmlFieldName.equals("positionLat")
				|| cmlFieldName.equals("positionLong")
				|| cmlFieldName.equals("endPositionLong")
				){
			data.put(cmlFieldName+"Degres",FitUtils.convertSemiCircleToDegres(Integer.valueOf(value)));
		}
	}
	
	
	public static void formatterSport(String cmlFieldName, String value, Map<String,Object> data){		
		if(cmlFieldName.equals("sport")){
			data.put("sportLibelle",Sport.getByValue(Short.valueOf(value)).name());
		}
	}
	
	
	public static void formatterManufacturer(String cmlFieldName, String value, Map<String,Object> data){
		if(cmlFieldName.equals("manufacturer")){
			data.put(cmlFieldName+"Libelle",ManufacturerEnum.getLibelleByCode(Integer.valueOf(value)));
		}		
	}

	public static void formatterProduct(String cmlFieldName, String value, Map<String,Object> data){
		if(cmlFieldName.equals("product") ||
				cmlFieldName.equals("garminProduct")){
			data.put(cmlFieldName+"Name",GarminProductEnum.getNameByCode(Integer.valueOf(value)));
			data.put(cmlFieldName+"Libelle",GarminProductEnum.getLibelleByCode(Integer.valueOf(value)));
		}	
	}
	
	public static void formatterEvent(String cmlFieldName, String value, Map<String,Object> data){
		if(cmlFieldName.equals("event")){
			data.put(cmlFieldName+"Libelle", Event.getByValue(Short.valueOf(value)).name());
		}
		if(cmlFieldName.equals("eventType")){
			data.put(cmlFieldName+"Libelle", EventType.getByValue(Short.valueOf(value)).name());
		}
	}
	
	
	public static void feedData(Mesg mesg, Field field, Map<String,Object> data){
		
		String value = FitUtils.getFieldValue(mesg, field);
		String fieldName = FitUtils.getFieldName(mesg, field);
		String cmlFieldName=  FitUtils.toCamelCase(fieldName);
		
		FitUtils.formatterEvent(cmlFieldName, value, data);
		FitUtils.formatterManufacturer(cmlFieldName, value, data);
		FitUtils.formatterProduct(cmlFieldName, value, data);			
		FitUtils.formatterGeo(cmlFieldName, value, data);
		FitUtils.formatterSport(cmlFieldName, value, data);
		if(!FitUtils.formatterTime(cmlFieldName, value, data)){
			data.put(cmlFieldName, value);
		}
	}

}

