// Code for Eclipse


import processing.core.PApplet;
import codeanticode.glgraphics.GLConstants;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.utils.MapUtils;

import de.fhpotsdam.unfolding.utils.*;
import de.fhpotsdam.unfolding.marker.*;
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.data.*;
import de.fhpotsdam.unfolding.geo.*;
import de.fhpotsdam.unfolding.providers.*;

import java.util.List;

/**
 * An application with a basic interactive map. You can zoom and pan the map.
 */
public class FabMapEclipse extends PApplet {

	UnfoldingMap map;

	public void setup() {
		size(800, 600, GLConstants.GLGRAPHICS);

		map = new UnfoldingMap(this);
		//map = new UnfoldingMap(this, new Microsoft.AerialProvider());
		//map = new UnfoldingMap(this, new StamenMapProvider.TonerLite());
		  
		map.zoomToLevel(2);
		MapUtils.createDefaultEventDispatcher(this, map);
		
		List<Feature> features = GeoJSONReader.loadData(this, "data.json");
		MarkerFactory markerFactory = new MarkerFactory();
		markerFactory.setPointClass(FabMarker.class);
		List<Marker> markers = markerFactory.createMarkers(features);
		map.addMarkers(markers);
	}

	public void draw() {
		map.draw();
	}
}
