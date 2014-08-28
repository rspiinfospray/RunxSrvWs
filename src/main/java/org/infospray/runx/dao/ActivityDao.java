package org.infospray.runx.dao;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.infospray.runx.fip.ActivityListener;
import org.infospray.runx.fip.DeviceInfoListener;
import org.infospray.runx.fip.EventListener;
import org.infospray.runx.fip.FileIdListener;
import org.infospray.runx.fip.HrvListener;
import org.infospray.runx.fip.LapListener;
import org.infospray.runx.fip.LengthListener;
import org.infospray.runx.fip.RecordListener;
import org.infospray.runx.fip.SessionListener;
import org.infospray.runx.fit.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;


@Repository
public class ActivityDao {

	@Autowired
	Fit2Dao ftiDao;
	

	private static String FILENAME = "2014-07-24-19-48-26.fit";


	public Activity  getFullActivity(){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		InputStream in = ftiDao.getFitFile(FILENAME);

		ActivityListener listenerActivity = new ActivityListener();
		EventListener listenerEvent = new EventListener();		
		LapListener listenerLap = new LapListener();
		RecordListener listenerRecord = new RecordListener();
		SessionListener listenerSession = new SessionListener();
		FileIdListener listenerFileId = new FileIdListener();
		LengthListener listenerLength = new LengthListener();
		DeviceInfoListener listenerDeviceInfo = new DeviceInfoListener();
		HrvListener listenerHrv = new HrvListener();

	
		mesgBroadcaster.addListener(listenerActivity);		
		mesgBroadcaster.addListener(listenerEvent);
		mesgBroadcaster.addListener(listenerLap);
		mesgBroadcaster.addListener(listenerRecord);
		mesgBroadcaster.addListener(listenerSession);
		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.addListener(listenerLength);
		mesgBroadcaster.addListener(listenerDeviceInfo);
		mesgBroadcaster.addListener(listenerHrv);
		mesgBroadcaster.run(in);		

		activity.getActivity().put("activity", listenerActivity.getData());		
		activity.getActivity().put("lap", listenerLap.getList());
		activity.getActivity().put("record", listenerRecord.getList());
		activity.getActivity().put("event", listenerEvent.getList());
		activity.getActivity().put("session", listenerSession.getData());
		activity.getActivity().put("fileId", listenerFileId.getData());
		activity.getActivity().put("length", listenerLength.getData());
		activity.getActivity().put("deviceInfo", listenerDeviceInfo.getList());
		activity.getActivity().put("hrv", listenerHrv.getData());


		return activity;
	}


	public Activity  getActivity(){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		InputStream in = ftiDao.getFitFile(FILENAME);
		ActivityListener listenerActivity = new ActivityListener();
		mesgBroadcaster.addListener(listenerActivity);		
		mesgBroadcaster.run(in);		
		activity.getActivity().put("activity", listenerActivity.getData());		

		return activity;
	}

	public List<Map<String,Object>>  getMapLap(){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		LapListener listenerLap = new LapListener();
		mesgBroadcaster.addListener(listenerLap);
		mesgBroadcaster.run(in);		

		return listenerLap.getList();
	}

	public List<Map<String,Object>>  getMapRecord(){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		RecordListener listenerRecord = new RecordListener();
		mesgBroadcaster.addListener(listenerRecord);
		mesgBroadcaster.run(in);		
		
		return listenerRecord.getList();
	}

	public List<Map<String,Object>>  getEvent(){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		EventListener listenerEvent = new EventListener();		
		mesgBroadcaster.addListener(listenerEvent);
		mesgBroadcaster.run(in);		
		return listenerEvent.getList();
	}

	public Map<String, Object>  getSession(){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		SessionListener listenerSession = new SessionListener();
		mesgBroadcaster.addListener(listenerSession);
		mesgBroadcaster.run(in);		
	
		return listenerSession.getData();
	}

	public Activity  getFileId(){

		Activity activity = new Activity();
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		FileIdListener listenerFileId = new FileIdListener();
		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.run(in);		
		activity.getActivity().put("fileId", listenerFileId.getData());

		return activity;
	}

	public Activity  getLength(){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		LengthListener listenerLength = new LengthListener();
		mesgBroadcaster.addListener(listenerLength);
		mesgBroadcaster.run(in);		
		activity.getActivity().put("length", listenerLength.getData());
		
		return activity;
	}

	public List<Map<String,Object>>  getDeviceInfo(){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		DeviceInfoListener listenerDeviceInfo = new DeviceInfoListener();
		mesgBroadcaster.addListener(listenerDeviceInfo);
		mesgBroadcaster.run(in);		

		return listenerDeviceInfo.getList();
	}


	public Activity  getHrv(){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
		HrvListener listenerHrv = new HrvListener();
		mesgBroadcaster.addListener(listenerHrv);
		mesgBroadcaster.run(in);		
		activity.getActivity().put("hrv", listenerHrv.getData());

		return activity;
	}





}
