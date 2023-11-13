package up.mi.projet.main.agglomeration;

import java.util.ArrayList;
import java.util.List;

public class Town {
  private final String name;
  private static final List<Town> towns = new ArrayList<>();

  public Town(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
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

  @Override
  public String toString() {
    return getName();
  }
}
