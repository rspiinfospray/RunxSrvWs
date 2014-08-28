package org.infospray.runx.hightchart.model;

import java.util.ArrayList;
import java.util.List;

public class Series {
	
	private String type;
	
	private String name;
	
	private Integer pointInterval;
	
	private Integer pointStart;
	
	private String color;
	
	List<List<Object>> data = new ArrayList<List<Object>>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPointInterval() {
		return pointInterval;
	}

	public void setPointInterval(Integer pointInterval) {
		this.pointInterval = pointInterval;
	}

	public Integer getPointStart() {
		return pointStart;
	}

	public void setPointStart(Integer pointStart) {
		this.pointStart = pointStart;
	}

	public List<List<Object>> getData() {
		return data;
	}

	public void setData(List<List<Object>> data) {
		this.data = data;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	

	

	
	
	
	

}
