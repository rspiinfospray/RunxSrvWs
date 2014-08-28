package org.infospray.runx.fit;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.CadenceZoneMesg;
import com.garmin.fit.CadenceZoneMesgListener;
import com.garmin.fit.Field;

public class CadenceZoneListener implements CadenceZoneMesgListener {


	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public Integer index = 0; 
	

	@Override
	public void onMesg(CadenceZoneMesg mesg) {
		Map<String,Object> lap = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, lap);							
			data.put(index, lap);			
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
