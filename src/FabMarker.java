import processing.core.PGraphics;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
 
public class FabMarker extends SimplePointMarker {
 
  public FabMarker(Location location) {
    super(location);
  }
 
  public void draw(PGraphics pg, float x, float y) {
    pg.pushStyle();
    pg.noStroke();
    pg.fill(255, 0, 0, 100);
    pg.ellipse(x, y, 10, 10);
    pg.popStyle();
  }
}
