package org.infospray.runx.fit;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.HrZoneMesg;
import com.garmin.fit.HrZoneMesgListener;

public class HrZoneListener implements HrZoneMesgListener {


	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public Integer index = 0; 
	

	@Override
	public void onMesg(HrZoneMesg mesg) {
		Map<String,Object> hr = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, hr);							
			data.put(index, hr);			
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
