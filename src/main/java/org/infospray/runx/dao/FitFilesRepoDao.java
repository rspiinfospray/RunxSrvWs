package org.infospray.runx.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.garmin.fit.Decode;


@Repository
public class FitFilesRepoDao {
	
	
	private final static String DIR_LOCATION = "C:\\Users\\amne\\workspace\\RunxSrc\\";
	
	public InputStream getFileByIdAndUserName(long idFile, String userName){
				
		FileInputStream fis = null; 
		
		
		if(String.valueOf(idFile).length() != 14){
			return null;
		}

		String path = DIR_LOCATION + userName +"\\" + this.longtoFileName(idFile) + ".fit";
		

		try {
			FileInputStream fisCheck = new FileInputStream(path);
			if(this.checkFileIntegrity(fisCheck)){
				fis = new FileInputStream(path);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return fis;
		
	}
	
	
	
	public List<String> getListActivityByUserName(String userName){
	
		File file = new File("C:\\Users\\amne\\workspace\\RunxSrc\\");

		List<String> listFile = new ArrayList<String>(Arrays.asList(file.list()));
		for (String listeFile : listFile) {
			listeFile = listeFile.replaceAll(".fit", "");
		}
		return listFile;
		
	}
	
	
	public boolean checkFileIntegrity(InputStream in){
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
	
	
	private String longtoFileName(long idFile){
		
		String fileName = String.valueOf(idFile);
		String year = fileName.substring(0, 4) + "-";
		String month = fileName.substring(4, 6)+ "-";
		String day = fileName.substring(6, 8)+ "-";
		String hour = fileName.substring(8, 10)+ "-";
		String min = fileName.substring(10, 12)+ "-";
		String sec =fileName.substring(12, 14);
		
		return year+month+day+hour+min+sec;
	}

}
