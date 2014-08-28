package org.infospray.runx.fit;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.garmin.fit.DeviceInfoMesg;
import com.garmin.fit.DeviceInfoMesgListener;
import com.garmin.fit.Field;

public class DeviceInfoListener implements DeviceInfoMesgListener  {

	public List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	
	@Override
	public void onMesg(DeviceInfoMesg mesg) {
		Map<String,Object> deviceInfos = new LinkedHashMap<String,Object>();

		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, deviceInfos);									
		}
		list.add(deviceInfos);
		
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	
}
