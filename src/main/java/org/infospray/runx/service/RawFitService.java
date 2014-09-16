package org.infospray.runx.service;


import java.util.List;
import java.util.Map;

import org.infospray.runx.fit.model.Activity;
import org.infospray.runx.fit.model.Sport;
import org.infospray.runx.fit.model.Totals;



public interface RawFitService {
	
	
	/// activity
	
	public Activity  getFullActivity(String userName, long idFile);

	public Activity  getActivity(String userName, long idFile);

	public List<Map<String,Object>>  getMapLap(String userName, long idFile);

	public List<Map<String,Object>>  getMapRecord(String userName, long idFile);
	
	public List<Map<String,Object>>  getEvent(String userName, long idFile);

	public Map<String, Object>  getSession(String userName, long idFile);
	
	public Activity  getActivityFileId(String userName, long idFile);
	
	public Activity  getLength(String userName, long idFile);
	
	public List<Map<String,Object>>  getDeviceInfo(String userName, long idFile);
	
	public Activity  getHrv(String userName, long idFile);
	
	
	/// settings
		
	public Totals getFullSettings(String userName, long idFile);

	public Totals getFileIdSettings(String userName, long idFile);
	
	public Totals getUserProfile(String userName, long idFile);
	
	/// sport
	
	public Sport  getFullSport(String userName, long idFile);

	public Sport  getFileIdSport(String userName, long idFile);

	public Sport  getZonesTarget(String userName, long idFile);
	
	public Sport  getSport(String userName, long idFile);
	
	public Sport  getSpeedZone(String userName, long idFile);
	
	public Sport  getMetSpeedZone(String userName, long idFile);
	
	public Sport  getPower(String userName, long idFile);
	
	public Sport  getHrZone(String userName, long idFile);
	
	public Sport  getCadence(String userName, long idFile);
	
	/// totals
	
	public Totals getFullTotals(String userName, long idFile);

	public Totals getFileIdTotals(String userName, long idFile);

	public Totals getTotals(String userName, long idFile);
	
}
