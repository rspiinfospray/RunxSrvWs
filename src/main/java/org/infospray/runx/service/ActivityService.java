package org.infospray.runx.service;

import java.util.List;

import org.infospray.runx.model.Lap;
import org.infospray.runx.model.Location;
import org.infospray.runx.model.Record;
import org.infospray.runx.model.Session;

public interface ActivityService {
	
	/**
	 * retourne la liste des LAPS
	 * @return
	 */
	public List<Lap> getListLaps(String user, long id);
	
	
	/**
	 * retourne la liste de tous les enregistrements
	 * @return
	 */
	public List<Record> getListRecords(String user, long id);
	
	/**
	 * calcul la vitesse max parmi tous les records
	 * @return
	 */
	public double getMaxSpeed(String user, long id);
	
	/**
	 * calcul la vitesse moyenne parmi tous les records
	 * @return
	 */
	public double getAvgSpeed(String user, long id);
	
	/**
	 * retourne toutes les informations liés a la session d entrainement
	 * @return
	 */
	public Session getSession(String user, long id);
	
	
	/**
	 * retourne le premier relevé gps trouvé
	 * @return
	 */
	public Location getFirstLocation(String user, long id);

}
