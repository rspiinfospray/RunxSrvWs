package org.infospray.runx.fip;

import java.util.LinkedHashMap;
import java.util.Map;

import com.garmin.fit.Field;
import com.garmin.fit.TotalsMesg;
import com.garmin.fit.TotalsMesgListener;

public class TotalsListener implements TotalsMesgListener {

	public Map<String,Object> data = new LinkedHashMap<String,Object>();

	@Override
	public void onMesg(TotalsMesg mesg) {

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
