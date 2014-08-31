package org.infospray.runx.controller;



import java.util.ArrayList;
import java.util.List;

import org.infospray.runx.hightchart.model.AxisTypeEnum;
import org.infospray.runx.hightchart.model.LineTimeChart;
import org.infospray.runx.hightchart.model.Series;
import org.infospray.runx.model.Record;
import org.infospray.runx.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("json/chart")
public class ChartController {
	
	@Autowired
	ActivityService activityService;
	
	@RequestMapping("/{user}/activity/{id}/speed/")
	LineTimeChart getSpeedChart(){
	

		LineTimeChart lineTime = new LineTimeChart();
		lineTime.getChart().setZoomType("x");
		lineTime.getTitle().setText("Vitesse");
		lineTime.getSubtitle().setText("Fluctuation de la vitesse en Kilometre/heure");
		lineTime.getxAxis().setType(AxisTypeEnum.DATETIME.getLibelle());
		lineTime.getyAxis().getTitle().setText("Kilometre/Heure");
		
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(1);
		
		List<Integer> litStop1 = new ArrayList<Integer>();
		litStop1.add(0);
		litStop1.add(124181236);
		
		List<Integer> litStop2 = new ArrayList<Integer>();
		litStop2.add(1);
		litStop2.add(124181236);
		lineTime.getPlotOptions().getArea().getFillColor().getStops().add(litStop1);
		lineTime.getPlotOptions().getArea().getFillColor().getStops().add(litStop2);

		
		lineTime.getPlotOptions().getArea().getMarker().setRadius(2);
		lineTime.getPlotOptions().getArea().setLineWidth(1);
		lineTime.getPlotOptions().getArea().getStates().getHover().setLineWidth(1);

		Series series = new Series();
		series.setName("Kilometre/Heure");

		for (Record currentRecord : activityService.getListRecords()) {
			
			List<Object> list = new ArrayList<Object>();
			list.add(currentRecord.getTimestamp() * 1000);
			list.add(currentRecord.getSpeed());
			series.getData().add(list);
		}
		
		lineTime.getSeries().add(series);
		
			
		return lineTime;
	}
	
	@RequestMapping("/{user}/activity/{id}/bpm/")
	LineTimeChart getBpmChart(){
	

		LineTimeChart lineTime = new LineTimeChart();
		lineTime.getChart().setZoomType("x");
		lineTime.getTitle().setText("BPM");
		lineTime.getSubtitle().setText("Fluctuation du rythme cardiaque en battement par minute");
		lineTime.getxAxis().setType(AxisTypeEnum.DATETIME.getLibelle());
		lineTime.getyAxis().getTitle().setText("BPM");
		
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(1);
		
		List<Integer> litStop1 = new ArrayList<Integer>();
		litStop1.add(0);
		litStop1.add(124181236);
		
		List<Integer> litStop2 = new ArrayList<Integer>();
		litStop2.add(1);
		litStop2.add(124181236);
		lineTime.getPlotOptions().getArea().getFillColor().getStops().add(litStop1);
		lineTime.getPlotOptions().getArea().getFillColor().getStops().add(litStop2);

		
		lineTime.getPlotOptions().getArea().getMarker().setRadius(2);
		lineTime.getPlotOptions().getArea().setLineWidth(1);
		lineTime.getPlotOptions().getArea().getStates().getHover().setLineWidth(1);

		Series series = new Series();
		series.setName("BPM");
		series.setColor("#B9121B");

		for (Record currentRecord : activityService.getListRecords()) {
			
			List<Object> list = new ArrayList<Object>();
			list.add(currentRecord.getTimestamp() * 1000);
			list.add(currentRecord.getHeartRate());
			series.getData().add(list);
		}
		
		lineTime.getSeries().add(series);
		
			
		return lineTime;
	}
	
	
	@RequestMapping("/{user}/activity/{id}/altitude/")
	LineTimeChart getAltitudeChart(){
	

		LineTimeChart lineTime = new LineTimeChart();
		lineTime.getChart().setZoomType("x");
		lineTime.getTitle().setText("Topographie du parcours");
		lineTime.getSubtitle().setText("Altitude");
		//lineTime.getxAxis().setType(AxisTypeEnum.DATETIME.getLibelle());
		lineTime.getyAxis().getTitle().setText("Mètres");
		
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(0);
		lineTime.getPlotOptions().getArea().getFillColor().getLinearGradient().add(1);
		
		List<Integer> litStop1 = new ArrayList<Integer>();
		litStop1.add(0);
		litStop1.add(124181236);
		
		List<Integer> litStop2 = new ArrayList<Integer>();
		litStop2.add(1);
		litStop2.add(124181236);
		lineTime.getPlotOptions().getArea().getFillColor().getStops().add(litStop1);
		lineTime.getPlotOptions().getArea().getFillColor().getStops().add(litStop2);

		
		lineTime.getPlotOptions().getArea().getMarker().setRadius(2);
		lineTime.getPlotOptions().getArea().setLineWidth(1);
		lineTime.getPlotOptions().getArea().getStates().getHover().setLineWidth(1);

		Series series = new Series();
		series.setName("Altitude en mètres");
		series.setColor("#096A09");

		for (Record currentRecord : activityService.getListRecords()) {
			
			List<Object> list = new ArrayList<Object>();
			list.add(currentRecord.getDistance());
			list.add(currentRecord.getAltitude());
			series.getData().add(list);
		}
		
		lineTime.getSeries().add(series);
		
			
		return lineTime;
	}
	
	

}
