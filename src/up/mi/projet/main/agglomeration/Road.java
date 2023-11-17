package up.mi.projet.main.agglomeration;

import java.util.ArrayList;
import java.util.List;

/**
 * The Road class represents a road in an agglomeration.
 * Each road has a list of towns it connects, an origin town, and a static list
 * of all roads.
 * 
 * The class provides the following methods:
 * 
 * - `Road(Town origin, Town destination)`: Constructor that initializes the
 * road with an origin and a destination town.
 * - `towns()`: Returns the list of towns the road connects.
 * - `setOrigin(Town newOrigin)`: Sets the origin town of the road.
 * - `getOrigin(Town town)`: Returns the origin town of the road.
 * - `getDestination()`: Returns the destination town of the road.
 * - `addRoad(Road road)`: Adds a road to the static list of all roads.
 * - `getRoads()`: Returns the static list of all roads.
 * - `toString()`: Returns a string representation of the road, showing the
 * origin and destination towns.
 */
public class Road {
  private List<Town> towns;
  private Town origin;
  private static final List<Road> roads = new ArrayList<>();

  public Road(Town origin, Town destination) {
    towns = new ArrayList<>(List.of(origin, destination));
  }

  public List<Town> towns() {
    return towns;
  }

  public void setOrigin(Town newOrigin) {
    Town town = towns.stream().filter(t -> t.equals(newOrigin)).findFirst().orElse(null);
    if (town != null) {
      origin = town;
    }
  }

  public Town getOrigin(Town town) {
    return origin;
  }

  public Town getDestination() {
    return towns.stream().filter(t -> !(t.equals(origin))).findFirst().orElse(null);
  }

  public static void addRoad(Road road) {
    roads.add(road);
  }

  public static List<Road> getRoads() {
    return roads;
  }

  @Override
  public String toString() {
    return String.format("%s -- %s", towns.get(0), towns.get(1));
  }
}
