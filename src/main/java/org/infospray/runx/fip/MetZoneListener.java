package org.infospray.runx.fip;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.MetZoneMesg;
import com.garmin.fit.MetZoneMesgListener;

public class MetZoneListener implements MetZoneMesgListener {


	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public Integer index = 0; 
	

	@Override
	public void onMesg(MetZoneMesg mesg) {
		Map<String,Object> met = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, met);							
			data.put(index, met);			
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
