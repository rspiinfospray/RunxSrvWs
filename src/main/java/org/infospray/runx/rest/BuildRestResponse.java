package org.infospray.runx.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BuildRestResponse {
	

	public static <T> ResponseEntity<ResponseBody<T>> buildFailed(Boolean isError, int errorCode, String errorLibelle){
		
		ResponseBody<T> body  = new ResponseBody<T>();
		body.setError(isError);
		body.setCodeError(errorCode);
		body.setErrorLibelle(errorLibelle);
		body.setBody(null);
		body.setNbResult(0);

		return  new ResponseEntity<ResponseBody<T>>(body , HttpStatus.OK);
	}


	public static <T> ResponseEntity<ResponseBody<T>> build(T data){

		ResponseBody<T> body  = new ResponseBody<T>();
		body.setError(Boolean.FALSE);		
		if(null != data){
			if(data instanceof List){
				if(!((List<?>)data).isEmpty()){
					body.setNbResult(((List<?>)data).size());
					body.setBody(data);
				}else{
					body.setNbResult(Integer.valueOf(0));
				}
			}else{
				body.setBody(data);
				body.setNbResult(Integer.valueOf(1));
			}
		}

		return  new ResponseEntity<ResponseBody<T>>(body , HttpStatus.OK);
	}

}
