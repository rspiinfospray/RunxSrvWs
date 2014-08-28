package org.infospray.runx.dao;

import java.io.InputStream;

import org.infospray.runx.fip.CadenceZoneListener;
import org.infospray.runx.fip.FileIdListener;
import org.infospray.runx.fip.HrZoneListener;
import org.infospray.runx.fip.MetZoneListener;
import org.infospray.runx.fip.PowerZoneListener;
import org.infospray.runx.fip.SpeedZoneListener;
import org.infospray.runx.fip.SportListener;
import org.infospray.runx.fip.ZonesTargetListener;
import org.infospray.runx.fit.model.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;


@Repository
public class SportDao {

	@Autowired
	FitDao ftiDao;
	
	
	private static String FILENAME = "Running.fit";


	public Sport  getFullSport(){

		Sport sport = new Sport();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		InputStream in = ftiDao.getFitFile(FILENAME);


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

	public Sport  getFileId(){

		Sport sport = new Sport();
		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		InputStream in = ftiDao.getFitFile(FILENAME);
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
		InputStream in = ftiDao.getFitFile(FILENAME);
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
		InputStream in = ftiDao.getFitFile(FILENAME);
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
		InputStream in = ftiDao.getFitFile(FILENAME);
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
		InputStream in = ftiDao.getFitFile(FILENAME);
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
		InputStream in = ftiDao.getFitFile(FILENAME);
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
		InputStream in = ftiDao.getFitFile(FILENAME);
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
		InputStream in = ftiDao.getFitFile(FILENAME);
		CadenceZoneListener listenerCadenceZone = new CadenceZoneListener();
		mesgBroadcaster.addListener(listenerCadenceZone);
		mesgBroadcaster.run(in);		
		sport.getSport().put("cadenceZone", listenerCadenceZone.getData());

		return sport;
	}

}
