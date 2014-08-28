package org.infospray.runx.fip;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.LapMesg;
import com.garmin.fit.LapMesgListener;

public class LapListener implements LapMesgListener  {

	public List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	

	
	@Override
	public void onMesg(LapMesg mesg) {

		Map<String,Object> lap = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, lap);									
		}
		list.add(lap);
	}



	public List<Map<String, Object>> getList() {
		return list;
	}



	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

}
