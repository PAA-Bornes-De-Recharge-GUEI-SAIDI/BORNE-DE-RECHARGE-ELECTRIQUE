package up.mi.projet.main.agglomeration;

import java.util.ArrayList;
import java.util.List;

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
    return getName();
  }
}
