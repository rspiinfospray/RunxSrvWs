package org.infospray.runx.rest;

public class ResponseBody<T> {
	
	private boolean error;
	
	private String 	errorLibelle;
	
	private Integer codeError;
	
	private Integer nbResult;
	
	private T body;

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public String getErrorLibelle() {
		return errorLibelle;
	}

	public void setErrorLibelle(String errorLibelle) {
		this.errorLibelle = errorLibelle;
	}

	public Integer getCodeError() {
		return codeError;
	}

	public void setCodeError(Integer codeError) {
		this.codeError = codeError;
	}

	public Integer getNbResult() {
		return nbResult;
	}

	public void setNbResult(Integer nbResult) {
		this.nbResult = nbResult;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
	
	

}
