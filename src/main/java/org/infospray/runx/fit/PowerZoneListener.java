package org.infospray.runx.fit;


import java.util.LinkedHashMap;
import java.util.Map;
import com.garmin.fit.Field;
import com.garmin.fit.PowerZoneMesg;
import com.garmin.fit.PowerZoneMesgListener;

public class PowerZoneListener implements PowerZoneMesgListener {


	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public Integer index = 0; 
	

	@Override
	public void onMesg(PowerZoneMesg mesg) {
		Map<String,Object> power = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, power);							
			data.put(index, power);			
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
