package org.infospray.runx.hightchart.model;

import java.util.ArrayList;
import java.util.List;

public class LineTimeChart {
	
	private Chart chart = new Chart();
	
	private Title title = new Title();
	
	private Subtitle subtitle = new Subtitle();
	
	private XAxis xAxis = new XAxis();
	
	private YAxis yAxis = new YAxis();
	
	private Legend legend = new Legend();
	
	private PlotOptions plotOptions = new PlotOptions();
	
	private List<Series> series =  new ArrayList<Series>();

	public Chart getChart() {
		return chart;
	}

	public void setChart(Chart chart) {
		this.chart = chart;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Subtitle getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(Subtitle subtitle) {
		this.subtitle = subtitle;
	}

	public XAxis getxAxis() {
		return xAxis;
	}

	public void setxAxis(XAxis xAxis) {
		this.xAxis = xAxis;
	}

	public YAxis getyAxis() {
		return yAxis;
	}

	public void setyAxis(YAxis yAxis) {
		this.yAxis = yAxis;
	}

	public Legend getLegend() {
		return legend;
	}

	public void setLegend(Legend legend) {
		this.legend = legend;
	}

	public PlotOptions getPlotOptions() {
		return plotOptions;
	}

	public void setPlotOptions(PlotOptions plotOptions) {
		this.plotOptions = plotOptions;
	}

	public List<Series> getSeries() {
		return series;
	}

	public void setSeries(List<Series> series) {
		this.series = series;
	}
	
	

}
