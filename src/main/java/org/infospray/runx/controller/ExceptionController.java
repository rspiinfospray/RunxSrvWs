package org.infospray.runx.controller;

import org.infospray.runx.rest.BuildRestResponse;
import org.infospray.runx.rest.ResponseBody;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice 
public class ExceptionController extends ResponseEntityExceptionHandler { 


	@ExceptionHandler(value = { EmptyResultDataAccessException.class }) 
	protected ResponseEntity<ResponseBody<Object>> EmptyResultException(Exception ex, 
			WebRequest request) { 
		ex.printStackTrace(); 
		return BuildRestResponse.buildFailed(Boolean.FALSE, HttpStatus.NOT_FOUND.value(), "Element non trouvé");

	}

	@ExceptionHandler(value = { Exception.class }) 
	protected ResponseEntity<ResponseBody<Object>> genericException(Exception ex, WebRequest request) { 
		ex.printStackTrace(); 
		return BuildRestResponse.buildFailed(Boolean.TRUE , HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erreur interne au serveur");
	}


}