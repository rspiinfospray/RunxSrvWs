package org.infospray.runx.dao;

import java.io.InputStream;

import org.infospray.runx.fip.FileIdListener;
import org.infospray.runx.fip.UserProfileListener;
import org.infospray.runx.fit.model.Totals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;

@Repository
public class SettingsDao {

	@Autowired
	FitDao fitDao;


	private static String FILENAME = "Settings.fit";
	
	public Totals getFullSettings(){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		FileIdListener listenerFileId = new FileIdListener();
		UserProfileListener listenerUserProfile = new UserProfileListener();

		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.addListener(listenerUserProfile);

		InputStream in = fitDao.getFitFile(FILENAME);

		mesgBroadcaster.run(in);

		totals.getTotals().put("fileId", listenerFileId.getData());
		totals.getTotals().put("userProfile", listenerUserProfile.getData());

		return totals;		
	}


	public Totals getFileId(){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		FileIdListener listenerFileId = new FileIdListener();
		mesgBroadcaster.addListener(listenerFileId);
		InputStream in = fitDao.getFitFile(FILENAME);
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

		InputStream in = fitDao.getFitFile(FILENAME);
		mesgBroadcaster.run(in);
		totals.getTotals().put("userProfile", listenerUserProfile.getData());

		return totals;		
	}



}
