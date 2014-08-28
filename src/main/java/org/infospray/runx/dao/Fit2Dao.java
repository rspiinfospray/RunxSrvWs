package org.infospray.runx.dao;


import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Repository;

import com.garmin.fit.Decode;

@Repository
public class Fit2Dao {


	
	public boolean checkFileIntegrity(String path){
		InputStream in = getClass().getClassLoader().getResourceAsStream(path);
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
			in = getClass().getClassLoader().getResourceAsStream(path);
		}

		return in;
	}


}
