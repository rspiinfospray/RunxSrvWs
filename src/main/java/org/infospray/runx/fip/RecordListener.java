package org.infospray.runx.fip;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;


public class RecordListener implements RecordMesgListener {


//	public Map<Integer,Map<String,Object>> data = new LinkedHashMap<Integer,Map<String,Object>>();
	
	public List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
	
	//public Integer index = 0;
	

	@Override
	public void onMesg(RecordMesg mesg) {

		Map<String,Object> record = new LinkedHashMap<String,Object>();
		
		for(Field curField : mesg.getFields()){			
			FitUtils.feedData(mesg, curField, record);							
			//data.put(index, record);			
		}
		list.add(record);
		//index++;	
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

	/*public Map<Integer, Map<String, Object>> getData() {
		return data;
	}

	public void setData(Map<Integer, Map<String, Object>> data) {
		this.data = data;
	}*/
	
	
	
	
}
