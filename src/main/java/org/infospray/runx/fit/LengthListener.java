package org.infospray.runx.fit;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.LengthMesg;
import com.garmin.fit.LengthMesgListener;

public class LengthListener implements LengthMesgListener {


	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();

	public Integer index = 0;


	@Override
	public void onMesg(LengthMesg mesg) {
		Map<String,Object> length = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, length);							
			data.put(index, length);			
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
