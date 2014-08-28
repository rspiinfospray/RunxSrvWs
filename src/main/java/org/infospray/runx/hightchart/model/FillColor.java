package org.infospray.runx.hightchart.model;

import java.util.ArrayList;
import java.util.List;

public class FillColor {
	
	private List<List<Integer>> stops = new ArrayList<List<Integer>>();
	
	private List<Integer> linearGradient=  new ArrayList<Integer>();

	public List<List<Integer>> getStops() {
		return stops;
	}

	public void setStops(List<List<Integer>> stops) {
		this.stops = stops;
	}

	public List<Integer> getLinearGradient() {
		return linearGradient;
	}

	public void setLinearGradient(List<Integer> linearGradient) {
		this.linearGradient = linearGradient;
	}

	

}
