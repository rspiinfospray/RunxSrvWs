package org.infospray.runx.fit;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.SessionMesg;
import com.garmin.fit.SessionMesgListener;

public class SessionListener implements SessionMesgListener {

	public Map<String,Object> data = new LinkedHashMap<String,Object>();


	@Override
	public void onMesg(SessionMesg mesg) {

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, data);									
		}
	}


	public Map<String, Object> getData() {
		return data;
	}


	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	


}
