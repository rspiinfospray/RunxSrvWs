package org.infospray.runx.fit;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.UserProfileMesg;
import com.garmin.fit.UserProfileMesgListener;

public class UserProfileListener implements UserProfileMesgListener {

	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();

	public Integer index = 0;


	@Override
	public void onMesg(UserProfileMesg mesg) {

		Map<String,Object> userProfile = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, userProfile);							
			data.put(index, userProfile);			
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
