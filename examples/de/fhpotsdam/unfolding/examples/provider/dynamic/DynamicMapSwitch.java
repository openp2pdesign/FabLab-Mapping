package de.fhpotsdam.unfolding.examples.provider.dynamic;

import processing.core.PApplet;
import codeanticode.glgraphics.GLConstants;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.mapdisplay.MapDisplayFactory;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.providers.OpenStreetMap;
import de.fhpotsdam.unfolding.utils.MapUtils;

/**
 * Enables switching between different maps with different tile providers.
 * 
 * All maps listen to map events themselves, i.e. all interactions affect each map, resulting in the same region. (Maps
 * are independent though.)
 * 
 * Only one map at a time is displayed, and only the tiles of that one will be loaded. Yet, switching is faster than
 * {@link DynamicProviderSwitch} after the tiles are loaded. It takes more memory though.
 */
public class DynamicMapSwitch extends PApplet {

	UnfoldingMap currentMap;

	UnfoldingMap map1;
	UnfoldingMap map2;
	UnfoldingMap map3;

	public void setup() {
		size(800, 600, GLConstants.GLGRAPHICS);

		map1 = new UnfoldingMap(this, new Google.GoogleMapProvider());
		map2 = new UnfoldingMap(this, new Microsoft.AerialProvider());
		map3 = new UnfoldingMap(this, new OpenStreetMap.CloudmadeProvider(MapDisplayFactory.OSM_API_KEY, 23058));

		MapUtils.createDefaultEventDispatcher(this, map1, map2, map3);

		currentMap = map1;
	}

	public void draw() {
		background(0);

		currentMap.draw();
	}

	public void keyPressed() {
		if (key == '1') {
			currentMap = map1;
		} else if (key == '2') {
			currentMap = map2;
		} else if (key == '3') {
			currentMap = map3;
		}
	}

}
