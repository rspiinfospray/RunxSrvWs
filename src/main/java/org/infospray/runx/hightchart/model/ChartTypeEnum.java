package org.infospray.runx.hightchart.model;

public enum ChartTypeEnum {
	
	
	
	AREA("area");
	
	private String libelle;

	ChartTypeEnum(String libelle){
		this.libelle = libelle;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
