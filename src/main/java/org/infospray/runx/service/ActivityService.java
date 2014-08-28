package org.infospray.runx.service;

import java.util.List;

import org.infospray.runx.model.Lap;
import org.infospray.runx.model.Record;
import org.infospray.runx.model.Session;

public interface ActivityService {
	
	public List<Lap>	getListLaps();
	
	public List<Record> getListRecords();
	
	/**
	 * calcul la vitesse max parmi tous les records
	 * @return
	 */
	public double getMaxSpeed();
	
	/**
	 * calcul la vitesse mooyenne parmi tous les records
	 * @return
	 */
	public double getAvgSpeed();
	
	/**
	 * retourne toutes les informations liés a la session d entrainement
	 * @return
	 */
	public Session getSession();

}
