package org.infospray.runx.fip;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.SportMesg;
import com.garmin.fit.SportMesgListener;

public class SportListener implements SportMesgListener {


	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public Integer index = 0; 
	

	@Override
	public void onMesg(SportMesg mesg) {
		Map<String,Object> sport = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, sport);							
			data.put(index, sport);			
		}

		index++;		
	}


	public Map<Integer, Map<String, Object>> getData() {
		return data;
	}


	public void setData(Map<Integer, Map<String, Object>> data) {
		this.data = data;
	}

	
	
	

	

}
