package org.infospray.runx.hightchart.model;

public enum AxisTypeEnum {
	
	
	
	DATETIME("datetime");
	
	private String libelle;

	AxisTypeEnum(String libelle){
		this.libelle = libelle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
