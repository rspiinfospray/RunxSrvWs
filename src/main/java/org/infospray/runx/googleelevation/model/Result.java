package org.infospray.runx.googleelevation.model;

import org.infospray.runx.model.Location;

public class Result {
	
	private Double elevation;
	private Location location = new Location();
	private Double resolution;
	public Double getElevation() {
		return elevation;
	}
	public void setElevation(Double elevation) {
		this.elevation = elevation;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Double getResolution() {
		return resolution;
	}
	public void setResolution(Double resolution) {
		this.resolution = resolution;
	}
	
	

}
