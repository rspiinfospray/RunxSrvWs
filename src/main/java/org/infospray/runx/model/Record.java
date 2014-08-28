package org.infospray.runx.model;

public class Record {
	

	private Double positionLatDegres;
	private Double positionLongDegres;
	private String distance;
	private String altitude;
	private Double speed;
	private Integer speedIndice;
	private String heure;
	private Boolean fixedSpeed;
	private Long	timestamp;
	

	public Double getPositionLatDegres() {
		return positionLatDegres;
	}
	public void setPositionLatDegres(Double positionLatDegres) {
		this.positionLatDegres = positionLatDegres;
	}

	public Double getPositionLongDegres() {
		return positionLongDegres;
	}
	public void setPositionLongDegres(Double positionLongDegres) {
		this.positionLongDegres = positionLongDegres;
	}

	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	public Double getSpeed() {
		return speed;
	}
	public void setSpeed(Double speed) {
		this.speed = speed;
	}
	public Integer getSpeedIndice() {
		return speedIndice;
	}
	public void setSpeedIndice(Integer speedIndice) {
		this.speedIndice = speedIndice;
	}
	public String getHeure() {
		return heure;
	}
	public void setHeure(String heure) {
		this.heure = heure;
	}
	public Boolean getFixedSpeed() {
		return fixedSpeed;
	}
	public void setFixedSpeed(Boolean fixedSpeed) {
		this.fixedSpeed = fixedSpeed;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	
	
	
	
	

}
