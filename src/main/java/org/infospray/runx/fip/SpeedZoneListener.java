package org.infospray.runx.fip;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.SpeedZoneMesg;
import com.garmin.fit.SpeedZoneMesgListener;

public class SpeedZoneListener implements SpeedZoneMesgListener {


	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public Integer index = 0; 
	

	@Override
	public void onMesg(SpeedZoneMesg mesg) {
		Map<String,Object> speed = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, speed);							
			data.put(index, speed);			
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
