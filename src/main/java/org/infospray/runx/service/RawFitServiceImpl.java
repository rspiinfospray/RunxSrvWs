package org.infospray.runx.service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.infospray.runx.dao.FitFilesRepoDao;
import org.infospray.runx.fit.ActivityListener;
import org.infospray.runx.fit.CadenceZoneListener;
import org.infospray.runx.fit.DeviceInfoListener;
import org.infospray.runx.fit.EventListener;
import org.infospray.runx.fit.FileIdListener;
import org.infospray.runx.fit.HrZoneListener;
import org.infospray.runx.fit.HrvListener;
import org.infospray.runx.fit.LapListener;
import org.infospray.runx.fit.LengthListener;
import org.infospray.runx.fit.MetZoneListener;
import org.infospray.runx.fit.PowerZoneListener;
import org.infospray.runx.fit.RecordListener;
import org.infospray.runx.fit.SessionListener;
import org.infospray.runx.fit.SpeedZoneListener;
import org.infospray.runx.fit.SportListener;
import org.infospray.runx.fit.TotalsListener;
import org.infospray.runx.fit.UserProfileListener;
import org.infospray.runx.fit.ZonesTargetListener;
import org.infospray.runx.fit.model.Activity;
import org.infospray.runx.fit.model.Sport;
import org.infospray.runx.fit.model.Totals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;



@Service
public class RawFitServiceImpl implements RawFitService {
	
	@Autowired
	FitFilesRepoDao ftiDaoRepo;
	
	
	public Activity  getFullActivity(String userName, long idFile){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile, userName);

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


	public Activity  getActivity(String userName, long idFile){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		ActivityListener listenerActivity = new ActivityListener();
		mesgBroadcaster.addListener(listenerActivity);		
		mesgBroadcaster.run(in);		
		activity.getActivity().put("activity", listenerActivity.getData());		

		return activity;
	}

	public List<Map<String,Object>>  getMapLap(String userName, long idFile){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		LapListener listenerLap = new LapListener();
		mesgBroadcaster.addListener(listenerLap);
		mesgBroadcaster.run(in);		

		return listenerLap.getList();
	}

	public List<Map<String,Object>>  getMapRecord(String userName, long idFile){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		RecordListener listenerRecord = new RecordListener();
		mesgBroadcaster.addListener(listenerRecord);
		mesgBroadcaster.run(in);		
		
		return listenerRecord.getList();
	}

	public List<Map<String,Object>>  getEvent(String userName, long idFile){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		EventListener listenerEvent = new EventListener();		
		mesgBroadcaster.addListener(listenerEvent);
		mesgBroadcaster.run(in);		
		return listenerEvent.getList();
	}

	public Map<String, Object>  getSession(String userName, long idFile){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		SessionListener listenerSession = new SessionListener();
		mesgBroadcaster.addListener(listenerSession);
		mesgBroadcaster.run(in);		
	
		return listenerSession.getData();
	}

	public Activity  getFileId(String userName, long idFile){

		Activity activity = new Activity();
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		FileIdListener listenerFileId = new FileIdListener();
		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.run(in);		
		activity.getActivity().put("fileId", listenerFileId.getData());

		return activity;
	}

	public Activity  getLength(String userName, long idFile){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		LengthListener listenerLength = new LengthListener();
		mesgBroadcaster.addListener(listenerLength);
		mesgBroadcaster.run(in);		
		activity.getActivity().put("length", listenerLength.getData());
		
		return activity;
	}

	public List<Map<String,Object>>  getDeviceInfo(String userName, long idFile){

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		DeviceInfoListener listenerDeviceInfo = new DeviceInfoListener();
		mesgBroadcaster.addListener(listenerDeviceInfo);
		mesgBroadcaster.run(in);		

		return listenerDeviceInfo.getList();
	}


	public Activity  getHrv(String userName, long idFile){

		Activity activity = new Activity();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(idFile ,userName);
		HrvListener listenerHrv = new HrvListener();
		mesgBroadcaster.addListener(listenerHrv);
		mesgBroadcaster.run(in);		
		activity.getActivity().put("hrv", listenerHrv.getData());

		return activity;
	}
	
	///// settings /////////////
	
	private static String FILENAME_SETTING = "Settings.fit";
	
	public Totals getFullSettings(String userName, long idFile){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		FileIdListener listenerFileId = new FileIdListener();
		UserProfileListener listenerUserProfile = new UserProfileListener();

		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.addListener(listenerUserProfile);

		InputStream in = ftiDaoRepo.getFileByIdAndUserName(4,FILENAME_SETTING);

		mesgBroadcaster.run(in);

		totals.getTotals().put("fileId", listenerFileId.getData());
		totals.getTotals().put("userProfile", listenerUserProfile.getData());

		return totals;		
	}


	public Totals getFileIdSetting(String userName, long idFile){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		FileIdListener listenerFileId = new FileIdListener();
		mesgBroadcaster.addListener(listenerFileId);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(4,FILENAME_SETTING);
		mesgBroadcaster.run(in);
		totals.getTotals().put("fileId", listenerFileId.getData());


		return totals;		
	}
	
	
	public Totals getUserProfile(){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		UserProfileListener listenerUserProfile = new UserProfileListener();
		mesgBroadcaster.addListener(listenerUserProfile);

		InputStream in = ftiDaoRepo.getFileByIdAndUserName(7,FILENAME_SETTING);
		mesgBroadcaster.run(in);
		totals.getTotals().put("userProfile", listenerUserProfile.getData());

		return totals;		
	}
	
	/////////////// sport
	
	private static String FILENAME_SPORT = "Running.fit";
	
	
	public Sport  getFullSport(){

		Sport sport = new Sport();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);


		FileIdListener listenerFileId = new FileIdListener();
		ZonesTargetListener listenerZonesTarget = new ZonesTargetListener();
		SportListener listenerSport = new SportListener();
		HrZoneListener listenerHrZone = new HrZoneListener();
		PowerZoneListener listenerPowerZone = new PowerZoneListener();
		MetZoneListener listenerMetZone = new MetZoneListener();
		SpeedZoneListener listenerSpeedZone =  new SpeedZoneListener();
		CadenceZoneListener listenerCadenceZone = new CadenceZoneListener();

		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.addListener(listenerZonesTarget);
		mesgBroadcaster.addListener(listenerSport);
		mesgBroadcaster.addListener(listenerHrZone);
		mesgBroadcaster.addListener(listenerPowerZone);
		mesgBroadcaster.addListener(listenerMetZone);
		mesgBroadcaster.addListener(listenerSpeedZone);
		mesgBroadcaster.addListener(listenerCadenceZone);

		mesgBroadcaster.run(in);		

		sport.getSport().put("fileId", listenerFileId.getData());
		sport.getSport().put("zonesTarget", listenerZonesTarget.getData());		
		sport.getSport().put("sport", listenerSport.getData());
		sport.getSport().put("hrZone", listenerHrZone.getData());
		sport.getSport().put("powerZone", listenerPowerZone.getData());
		sport.getSport().put("metZone", listenerMetZone.getData());
		sport.getSport().put("speedZone", listenerSpeedZone.getData());
		sport.getSport().put("cadenceZone", listenerCadenceZone.getData());

		return sport;
	}

	public Sport  getFileIdSport(String userName, long idFile){

		Sport sport = new Sport();
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		FileIdListener listenerFileId = new FileIdListener();
		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.run(in);		
		sport.getSport().put("fileId", listenerFileId.getData());


		return sport;
	}

	public Sport  getZonesTarget(){

		Sport sport = new Sport();
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		ZonesTargetListener listenerZonesTarget = new ZonesTargetListener();
		mesgBroadcaster.addListener(listenerZonesTarget);
		mesgBroadcaster.run(in);		
		sport.getSport().put("zonesTarget", listenerZonesTarget.getData());		

		return sport;
	}
	
	public Sport  getSport(){

		Sport sport = new Sport();
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		SportListener listenerSport = new SportListener();
		mesgBroadcaster.addListener(listenerSport);;
		mesgBroadcaster.run(in);		
		sport.getSport().put("sport", listenerSport.getData());		

		return sport;
	}
	
	
	public Sport  getSpeedZone(){

		Sport sport = new Sport();
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		SpeedZoneListener listenerSpeedZone =  new SpeedZoneListener();
		mesgBroadcaster.addListener(listenerSpeedZone);
		mesgBroadcaster.run(in);		
		sport.getSport().put("speedZone", listenerSpeedZone.getData());

		return sport;
	}

	
	public Sport  getMetSpeedZone(){

		Sport sport = new Sport();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		MetZoneListener listenerMetZone =  new MetZoneListener();
		mesgBroadcaster.addListener(listenerMetZone);
		mesgBroadcaster.run(in);		
		sport.getSport().put("metZone", listenerMetZone.getData());

		return sport;
	}
	
	
	public Sport  getPower(){

		Sport sport = new Sport();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		PowerZoneListener listenerPowerZone = new PowerZoneListener();
		mesgBroadcaster.addListener(listenerPowerZone);
		mesgBroadcaster.run(in);		
		sport.getSport().put("powerZone", listenerPowerZone.getData());
	
		return sport;
	}
	
	
	public Sport  getHrZone(){

		Sport sport = new Sport();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		HrZoneListener listenerHrZone = new HrZoneListener();
		mesgBroadcaster.addListener(listenerHrZone);
		mesgBroadcaster.run(in);		
		sport.getSport().put("hrZone", listenerHrZone.getData());
		
		return sport;
	}
	
	
	public Sport  getCadence(){

		Sport sport = new Sport();
		
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(5,FILENAME_SPORT);
		CadenceZoneListener listenerCadenceZone = new CadenceZoneListener();
		mesgBroadcaster.addListener(listenerCadenceZone);
		mesgBroadcaster.run(in);		
		sport.getSport().put("cadenceZone", listenerCadenceZone.getData());

		return sport;
	}
	
	
	////////////////// totals
	
	private static String FILENAME_TOTALS = "Totals.fit";
	
	public Totals getFullTotals(String userName, long idFile){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		FileIdListener listenerFileId = new FileIdListener();
		TotalsListener listenerTotals = new TotalsListener();

		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.addListener(listenerTotals);

		InputStream in = ftiDaoRepo.getFileByIdAndUserName(4,FILENAME_TOTALS);

		mesgBroadcaster.run(in);

		totals.getTotals().put("fileId", listenerFileId.getData());
		totals.getTotals().put("totals", listenerTotals.getData());

		return totals;		
	}


	public Totals getFileIdTotals(String userName, long idFile){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		FileIdListener listenerFileId = new FileIdListener();
		mesgBroadcaster.addListener(listenerFileId);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(4,FILENAME_TOTALS);
		mesgBroadcaster.run(in);
		totals.getTotals().put("fileId", listenerFileId.getData());


		return totals;		
	}


	public Totals getTotals(String userName, long idFile){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		TotalsListener listenerTotals = new TotalsListener();
		mesgBroadcaster.addListener(listenerTotals);
		InputStream in = ftiDaoRepo.getFileByIdAndUserName(1,FILENAME_TOTALS);
		mesgBroadcaster.run(in);
		totals.getTotals().put("totals", listenerTotals.getData());

		return totals;		
	}


	@Override
	public Activity getActivityFileId(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Totals getFileIdSettings(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Totals getUserProfile(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getFullSport(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getZonesTarget(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getSport(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getSpeedZone(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getMetSpeedZone(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getPower(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getHrZone(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sport getCadence(String userName, long idFile) {
		// TODO Auto-generated method stub
		return null;
	}


}
