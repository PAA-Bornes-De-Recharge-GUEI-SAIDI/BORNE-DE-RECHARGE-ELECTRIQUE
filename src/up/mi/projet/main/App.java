package up.mi.projet.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import up.mi.projet.main.agglomeration.Road;
import up.mi.projet.main.agglomeration.Town;

/**
 * The App class is the main class of the application.
 * It provides a console-based user interface to manage towns, roads, and
 * stations.
 * 
 * The class provides the following methods:
 * 
 * - `main(String[] args)`: The main method of the application. It handles user
 * input and controls the flow of the application.
 * - `addStation(BufferedReader reader)`: Prompts the user to add a station to a
 * town.
 * - `checkIfTownHasStation(Town origin, Town ignore, StringBuilder sb)`: Checks
 * if a town has a station or if it's connected to a town that has a station.
 * - `removeStation(BufferedReader reader)`: Prompts the user to remove a
 * station from a town.
 * - `addRoad(BufferedReader reader)`: Prompts the user to add a road between
 * two towns.
 */
public class App {
  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int nbVilles = 0;
      do {
        System.out.print("Entrez le nombre de ville souhaité (26 max) : ");
        nbVilles = Integer.parseInt(reader.readLine());
      } while (nbVilles < 2 || nbVilles > 26);

      // create a new instance of the class Agglomeration
      char[] nomVillesPotentielle = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L' };
      for (int i = 0; i < nbVilles; i++) {
        Town.addTown(new Town(String.valueOf(nomVillesPotentielle[i])));
      }

      // show the list of towns
      System.out.println("Liste des villes : " + Town.getTowns());

      while (true) {
        // create menu
        System.out.println("1 - Ajouter une route");
        System.out.println("2 - fin");
        System.out.print("Votre choix : ");
        String choice = reader.readLine();

        // end condition
        if (choice.equals("2")) {
          break;
        }

        if (choice.equals("1")) {
          addRoad(reader);
          // show the list of roads
          System.out.println("Liste des routes : " + Road.getRoads());
        }
      }

      while (true) {
        System.out.println("1 - Ajouter une zone de recharge");
        System.out.println("2 - Retirer une zone de recharge");
        System.out.println("3 - fin");
        System.out.print("Votre choix : ");
        String choice = reader.readLine();

        // end condition
        if (choice.equals("3")) {
          break;
        } else if (choice.equals("1")) {
          addStation(reader);
          // System.out.println(Town.getTownsByStation());
          System.out.println(Town.getTowns());
        } else if (choice.equals("2")) {
          removeStation(reader);
          // System.out.println(Town.getTownsByStation());
          System.out.println(Town.getTowns());
        }
      }

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

  }

  public static void addStation(BufferedReader reader) throws IOException {
    System.out.println("Liste des villes : " + Town.getTowns());
    System.out.print("Quelle ville : ");

    Town town = Town.getTownByName(reader.readLine());

    town.addStation();
  }

  public static boolean checkIfTownHasStation(Town origin, Town ignore, StringBuilder sb) {
    List<Road> roads = Road.getRoads().stream()
        .filter(road -> road.towns().contains(origin))
        .filter(road -> !road.towns().contains(ignore)).toList();

    if (roads.isEmpty())
      return false;

    boolean hasStation = false;

    for (Road road : roads) {
      road.setOrigin(origin);
      Town destiTown = road.getDestination();
      if (destiTown.getStation() == null) {
        if (checkIfTownHasStation(destiTown, origin, sb)) {
          if (ignore != null)
            return hasStation && true;
          else
            sb.append(road + ", ");
        } else {
          sb.append(road + ", ");
          return false;
        }
      } else {
        hasStation = true;
      }
    }

    return hasStation;
  }

  public static void removeStation(BufferedReader reader) throws IOException {
    System.out.println("Liste des villes : " + Town.getTowns());
    System.out.print("Quelle ville : ");

    Town town = Town.getTownByName(reader.readLine());

    StringBuilder sb = new StringBuilder();

    boolean aUneStationProche = checkIfTownHasStation(town, null, sb);

    if (aUneStationProche) {
      town.removeStation();
    } else {
      System.out.println("Supprimer la station va à l'encontre de la règle d’accessibilité avec : " + sb);
    }
  }

  public static void addRoad(BufferedReader reader) throws IOException {
    System.out.println("Liste des villes : " + Town.getTowns());

    System.out.print("Quelle ville de départ : ");
    String origin = reader.readLine();

    System.out.print("Quelle ville d'arrivée : ");
    String destination = reader.readLine();

    Road.addRoad(new Road(Town.getTownByName(origin), Town.getTownByName(destination)));
  }
}
