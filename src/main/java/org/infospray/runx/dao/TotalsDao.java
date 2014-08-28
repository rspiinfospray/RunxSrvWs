package org.infospray.runx.dao;

import java.io.InputStream;

import org.infospray.runx.fip.FileIdListener;
import org.infospray.runx.fip.TotalsListener;
import org.infospray.runx.fit.model.Totals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;

@Repository
public class TotalsDao {

	@Autowired
	FitDao fitDao;


	private static String FILENAME = "Totals.fit";
	
	public Totals getFullTotals(){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);

		FileIdListener listenerFileId = new FileIdListener();
		TotalsListener listenerTotals = new TotalsListener();

		mesgBroadcaster.addListener(listenerFileId);
		mesgBroadcaster.addListener(listenerTotals);

		InputStream in = fitDao.getFitFile(FILENAME);

		mesgBroadcaster.run(in);

		totals.getTotals().put("fileId", listenerFileId.getData());
		totals.getTotals().put("totals", listenerTotals.getData());

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


	public Totals getTotals(){

		Totals totals = new Totals();

		Decode decode = new Decode();
		MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
		TotalsListener listenerTotals = new TotalsListener();
		mesgBroadcaster.addListener(listenerTotals);
		InputStream in = fitDao.getFitFile(FILENAME);
		mesgBroadcaster.run(in);
		totals.getTotals().put("totals", listenerTotals.getData());

		return totals;		
	}

}
