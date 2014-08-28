package org.infospray.runx.fip;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.ActivityMesg;
import com.garmin.fit.ActivityMesgListener;
import com.garmin.fit.Field;


public class ActivityListener implements ActivityMesgListener  {


	public Map<String,Object> data = new LinkedHashMap<String,Object>();

	@Override
	public void onMesg(ActivityMesg mesg) {

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
