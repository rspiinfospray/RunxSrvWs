package org.infospray.runx.fip;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.HrvMesg;
import com.garmin.fit.HrvMesgListener;

public class HrvListener implements HrvMesgListener {

	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public Integer index = 0; 
	

	@Override
	public void onMesg(HrvMesg mesg) {
		Map<String,Object> hrv = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, hrv);							
			data.put(index, hrv);			
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
