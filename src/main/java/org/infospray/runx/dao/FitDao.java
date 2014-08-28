package org.infospray.runx.dao;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Repository;

import com.garmin.fit.Decode;

@Repository
public class FitDao {


	
	public boolean checkFileIntegrity(String path){
		InputStream in = getClass().getResourceAsStream(path);
		if(null != in){
			if (Decode.checkIntegrity((InputStream) in)){
				try {
					in.close();
				} catch (IOException e) {
				}
				return true;
			}
		}

		return false;
	}
	
	public InputStream getFitFile(String path){

		InputStream in = null; 

		if(this.checkFileIntegrity(path)){
			in = getClass().getResourceAsStream(path);
		}

		return in;
	}


}
