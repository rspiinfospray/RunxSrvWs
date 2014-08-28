package org.infospray.runx.service;


import java.util.List;
import java.util.Map;

import org.infospray.runx.dao.ActivityDao;
import org.infospray.runx.dao.SportDao;
import org.infospray.runx.dao.TotalsDao;
import org.infospray.runx.fit.model.Activity;
import org.infospray.runx.fit.model.DeviceFile;
import org.infospray.runx.fit.model.Settings;
import org.infospray.runx.fit.model.Sport;
import org.infospray.runx.fit.model.Totals;
import org.infospray.runx.fit.model.Weight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class FitImpl implements FitService {
	
	@Autowired
	ActivityDao activityDao;
	
	@Autowired
	TotalsDao totalsDao;
	
	@Autowired
	SportDao sportDao;

	@Override
	public Totals getFitTotals(String user) {
		return totalsDao.getFullTotals();
	}

	@Override
	public Totals getFitTotalsFileId(String user) {
		return totalsDao.getFileId();
	}

	@Override
	public Totals getFitTotalsTotals(String user) {
		return totalsDao.getTotals();
	}

	/**
	 * Activity
	 */
	
	@Override
	public Activity getFitActivityHrv(String user, long id) {
		return activityDao.getHrv();
	}

	@Override
	public Activity getFitActivity(String user, long id) {
		return activityDao.getFullActivity();
	}

	@Override
	public Activity getFitActivityFileId(String user, long id) {
		return activityDao.getFileId();
	}

	@Override
	public Activity getFitActivityActivity(String user, long id) {
		return activityDao.getActivity();
	}

	@Override
	public Map<String, Object> getFitActivitySession(String user, long id) {
		return activityDao.getSession();
	}

	@Override
	public List<Map<String, Object>> getFitActivityLap(String user, long id) {
		return activityDao.getMapLap();
	}

	@Override
	public Activity getFitActivityLength(String user, long id) {
		return activityDao.getLength();
	}

	@Override
	public List<Map<String, Object>> getFitActivityDeviceInfo(String user, long id) {
		return activityDao.getDeviceInfo();
	}

	@Override
	public List<Map<String, Object>> getFitActivityRecord(String user, long id) {
		return activityDao.getMapRecord();
	}

	@Override
	public List<Map<String, Object>> getFitActivityEvent(String user, long id) {
		return activityDao.getEvent();
	}

	/**
	 * Sport
	 */
	
	@Override
	public Sport getFitSportsSpeedZone(String user) {
		return sportDao.getSpeedZone();
	}

	@Override
	public Sport getFitSportsMetZone(String user) {
		return this.sportDao.getMetSpeedZone();
	}

	@Override
	public Sport getFitSportsPowerZone(String user) {
		return this.sportDao.getPower();
	}

	@Override
	public Sport getFitSportsHrZone(String user) {
		return this.sportDao.getHrZone();
	}

	@Override
	public Sport getFitSportsSport(String user) {
		return this.sportDao.getSport();
	}

	@Override
	public Sport getFitSportsZoneTarget(String user) {
		return this.sportDao.getZonesTarget();
	}

	@Override
	public Sport getFitSportsFileId(String user) {
		return this.sportDao.getFileId();
	}

	@Override
	public Sport getFitSports(String user) {
		return this.sportDao.getFullSport();
	}

	/**
	 * Settings
	 */
	
	@Override
	public Settings getFitSettingsFileId(String user, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Settings getFitSettings(String user, long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weight getFitWeight(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weight getFitWeightFileId(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weight getFitWeightUserProfile(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weight getFitWeightWeightSacale(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Weight getFitWeightDeviceInfos(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceFile getFitDevices(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceFile getFitDevicesFileId(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceFile getFitDevicesSoftware(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceFile getFitDevicesCapabilities(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceFile getFitDevicesFileCapabilities(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceFile getFitDevicesMesgCapabilities(String user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeviceFile getFitDevicesFieldCappabilities(String user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	

}
