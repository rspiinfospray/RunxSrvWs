package org.infospray.runx.fip;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.garmin.fit.EventMesg;
import com.garmin.fit.EventMesgListener;
import com.garmin.fit.Field;

public class EventListener implements EventMesgListener {
	
public List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	

	@Override
	public void onMesg(EventMesg mesg) {

		Map<String,Object> event = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, event);	
		}

		list.add(event);
	}


	public List<Map<String, Object>> getList() {
		return list;
	}


	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	

}
