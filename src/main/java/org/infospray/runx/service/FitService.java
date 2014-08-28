package org.infospray.runx.service;

import java.util.List;
import java.util.Map;

import org.infospray.runx.fit.model.Activity;
import org.infospray.runx.fit.model.DeviceFile;
import org.infospray.runx.fit.model.Settings;
import org.infospray.runx.fit.model.Sport;
import org.infospray.runx.fit.model.Totals;
import org.infospray.runx.fit.model.Weight;

public interface FitService {
	

	
	public Totals getFitTotals(String user);

	public Totals getFitTotalsFileId(String user);

	public Totals getFitTotalsTotals(String user);


	public Activity getFitActivityHrv(String user, long id);

	public Activity getFitActivity(String user, long id);

	public Activity getFitActivityFileId(String user, long id);

	public Activity getFitActivityActivity(String user, long id);

	public Map<String, Object> getFitActivitySession(String user, long id);

	public List<Map<String, Object>> getFitActivityLap(String user, long id);

	public Activity getFitActivityLength(String user, long id);

	public List<Map<String, Object>> getFitActivityDeviceInfo(String user, long id);

	public List<Map<String, Object>> getFitActivityRecord(String user, long id);

	public List<Map<String, Object>> getFitActivityEvent(String user, long id);

	public Sport getFitSportsSpeedZone(String user);

	public Sport getFitSportsMetZone(String user);

	public Sport getFitSportsPowerZone(String user);

	public Sport getFitSportsHrZone(String user);

	public Sport getFitSportsSport(String user);

	public Sport getFitSportsZoneTarget(String user);

	public Sport getFitSportsFileId(String user);

	public Sport getFitSports(String user);

	public Settings getFitSettingsFileId(String user, long id);

	public Settings getFitSettings(String user, long id);

	public Weight getFitWeight(String user);

	public Weight getFitWeightFileId(String user);

	public Weight getFitWeightUserProfile(String user);

	public Weight getFitWeightWeightSacale(String user);

	public Weight getFitWeightDeviceInfos(String user);

	public DeviceFile getFitDevices(String user);

	public DeviceFile getFitDevicesFileId(String user);

	public DeviceFile getFitDevicesSoftware(String user);

	public DeviceFile getFitDevicesCapabilities(String user);

	public DeviceFile getFitDevicesFileCapabilities(String user);

	public DeviceFile getFitDevicesMesgCapabilities(String user);

	public DeviceFile getFitDevicesFieldCappabilities(String user);


}
