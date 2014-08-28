package org.infospray.runx.model;

public class Session {
	
	private Long stopActivityTime;
	private Long startActivityTime;
	private Double startPositionLatDegres;
	private Double startPositionLongDegres;
	private Double totalElapsedTime;
	private Double totalTimerTime;
	private Double totalDistance;
	private Integer messageIndex;
	private Integer totalCalories;
	// sans correction
	private Double avgSpeed;
	// sans correction
	private Double maxSpeed;
	private Integer totalAscent;
	private Integer totalDescent;
	private Integer firstLapIndex;
	private Integer numLaps;
	private String eventLibelle;
	private Integer event;
	private String eventTypeLibelle;
	private Integer eventType;
	private String sportLibelle;
	private Integer sport;
	private Integer subSport;
	

	
	
	public Long getStopActivityTime() {
		return stopActivityTime;
	}
	public void setStopActivityTime(Long stopActivityTime) {
		this.stopActivityTime = stopActivityTime;
	}
	public Long getStartActivityTime() {
		return startActivityTime;
	}
	public void setStartActivityTime(Long startActivityTime) {
		this.startActivityTime = startActivityTime;
	}
	public Double getStartPositionLatDegres() {
		return startPositionLatDegres;
	}
	public void setStartPositionLatDegres(Double startPositionLatDegres) {
		this.startPositionLatDegres = startPositionLatDegres;
	}
	public Double getStartPositionLongDegres() {
		return startPositionLongDegres;
	}
	public void setStartPositionLongDegres(Double startPositionLongDegres) {
		this.startPositionLongDegres = startPositionLongDegres;
	}
	public Double getTotalElapsedTime() {
		return totalElapsedTime;
	}
	public void setTotalElapsedTime(Double totalElapsedTime) {
		this.totalElapsedTime = totalElapsedTime;
	}
	public Double getTotalTimerTime() {
		return totalTimerTime;
	}
	public void setTotalTimerTime(Double totalTimerTime) {
		this.totalTimerTime = totalTimerTime;
	}
	public Double getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(Double totalDistance) {
		this.totalDistance = totalDistance;
	}
	public Integer getMessageIndex() {
		return messageIndex;
	}
	public void setMessageIndex(Integer messageIndex) {
		this.messageIndex = messageIndex;
	}
	public Integer getTotalCalories() {
		return totalCalories;
	}
	public void setTotalCalories(Integer totalCalories) {
		this.totalCalories = totalCalories;
	}
	public Double getAvgSpeed() {
		return avgSpeed;
	}
	public void setAvgSpeed(Double avgSpeed) {
		this.avgSpeed = avgSpeed;
	}
	public Double getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(Double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	public Integer getTotalAscent() {
		return totalAscent;
	}
	public void setTotalAscent(Integer totalAscent) {
		this.totalAscent = totalAscent;
	}
	public Integer getTotalDescent() {
		return totalDescent;
	}
	public void setTotalDescent(Integer totalDescent) {
		this.totalDescent = totalDescent;
	}
	public Integer getFirstLapIndex() {
		return firstLapIndex;
	}
	public void setFirstLapIndex(Integer firstLapIndex) {
		this.firstLapIndex = firstLapIndex;
	}
	public Integer getNumLaps() {
		return numLaps;
	}
	public void setNumLaps(Integer numLaps) {
		this.numLaps = numLaps;
	}
	public String getEventLibelle() {
		return eventLibelle;
	}
	public void setEventLibelle(String eventLibelle) {
		this.eventLibelle = eventLibelle;
	}
	public Integer getEvent() {
		return event;
	}
	public void setEvent(Integer event) {
		this.event = event;
	}
	public String getEventTypeLibelle() {
		return eventTypeLibelle;
	}
	public void setEventTypeLibelle(String eventTypeLibelle) {
		this.eventTypeLibelle = eventTypeLibelle;
	}
	public Integer getEventType() {
		return eventType;
	}
	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}
	public String getSportLibelle() {
		return sportLibelle;
	}
	public void setSportLibelle(String sportLibelle) {
		this.sportLibelle = sportLibelle;
	}
	public Integer getSport() {
		return sport;
	}
	public void setSport(Integer sport) {
		this.sport = sport;
	}
	public Integer getSubSport() {
		return subSport;
	}
	public void setSubSport(Integer subSport) {
		this.subSport = subSport;
	}
	
	

}
