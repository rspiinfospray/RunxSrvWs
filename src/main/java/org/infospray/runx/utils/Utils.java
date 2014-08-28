package org.infospray.runx.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utils {
	
	
	public static double MAX_SPEED_RUNNING_LIMIT = 25.0d; // plus de 25km/h pour un runner c cho :D
	
	public static String timestampToDateString(long timestamp){
		
		Date date = new Date(timestamp*1000L); // *1000 is to convert seconds to milliseconds
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); // the format of your date
		sdf.setTimeZone(TimeZone.getTimeZone("GMT+1"));
		String formattedDate = sdf.format(date);
		return formattedDate;
	}

	public static Double mettreSecondeToKilometreHeure(String mettreSeconde) {
		
		BigDecimal converter = new BigDecimal(3.6d);
		BigDecimal bMettreSeconde = BigDecimal.valueOf(Double.valueOf(mettreSeconde));
		
		BigDecimal kiloMettreHeure = bMettreSeconde.multiply(converter);
		
		kiloMettreHeure = kiloMettreHeure.setScale(2, RoundingMode.HALF_DOWN);
		
		return kiloMettreHeure.doubleValue();
	}

}
