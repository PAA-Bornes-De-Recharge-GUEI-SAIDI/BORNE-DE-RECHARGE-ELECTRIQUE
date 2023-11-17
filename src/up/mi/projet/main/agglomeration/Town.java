package up.mi.projet.main.agglomeration;

import java.util.ArrayList;
import java.util.List;

/**
 * The Town class represents a town in an agglomeration.
 * Each town has a name and may have a station.
 * The class also maintains a static list of all towns for easy access.
 * 
 * The class provides the following methods:
 * 
 * - `Town(String name)`: Constructor that initializes the town with a name and
 * a new station.
 * - `getName()`: Returns the name of the town.
 * - `getStation()`: Returns the station of the town.
 * - `addStation()`: Adds a new station to the town.
 * - `removeStation()`: Removes the station from the town.
 * - `addTown(Town town)`: Adds a town to the static list of all towns.
 * - `getTowns()`: Returns the static list of all towns.
 * - `getTownByName(String name)`: Returns a town from the static list of all
 * towns by its name.
 * - `getTownsByStation()`: Returns a list of all towns from the static list of
 * all towns that have a station.
 * - `toString()`: Returns a string representation of the town, appending a "^"
 * if the town does not have a station.
 */
public class Town {
  private final String name;
  private Station station;
  private static final List<Town> towns = new ArrayList<>();

  public Town(String name) {
    this.name = name;
    station = new Station();
  }

  public String getName() {
    return name;
  }

  public Station getStation() {
    return station;
  }

  public void addStation() {
    station = new Station();
  }

  public void removeStation() {
    station = null;
  }

  public static void addTown(Town town) {
    towns.add(town);
  }

  public static List<Town> getTowns() {
    return towns;
  }

  // get the town by its name
  public static Town getTownByName(String name) {
    for (Town town : towns) {
      if (town.getName().equals(name)) {
        return town;
      }
    }

    return null;
  }

  public static List<Town> getTownsByStation() {
    List<Town> townsByStation = new ArrayList<>();

    for (Town town : towns) {
      if (town.getStation() != null) {
        townsByStation.add(town);
      }
    }

    return townsByStation;
  }

  @Override
  public String toString() {
    return getName().concat(station == null ? "^" : "");
  }
}
