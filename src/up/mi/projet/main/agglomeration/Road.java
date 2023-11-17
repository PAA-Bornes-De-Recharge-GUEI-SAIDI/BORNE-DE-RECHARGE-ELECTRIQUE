package up.mi.projet.main.agglomeration;

import java.util.ArrayList;
import java.util.List;

public class Road {
  private Town origin;
  private Town destination;
  private static final List<Road> roads = new ArrayList<>();

  public Road(Town origin, Town destination) {
    this.origin = origin;
    this.destination = destination;
  }

  public Town getOrigin() {
    return origin;
  }

  public Town getDestination() {
    return destination;
  }

  public static void addRoad(Road road) {
    roads.add(road);
  }

  public static List<Road> getRoads() {
    return roads;
  }

  @Override
  public String toString() {
    return String.format("%s -> %s", origin, destination);
  }
}
