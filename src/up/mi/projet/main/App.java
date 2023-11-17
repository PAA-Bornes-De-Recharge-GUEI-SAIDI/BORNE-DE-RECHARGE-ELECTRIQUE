package up.mi.projet.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import up.mi.projet.main.agglomeration.Road;
import up.mi.projet.main.agglomeration.Town;

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
          System.out.println(Town.getTownsByStation());
        } else if (choice.equals("2")) {
          removeStation(reader);
          System.out.println(Town.getTownsByStation());
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

  public static void removeStation(BufferedReader reader) throws IOException {
    System.out.println("Liste des villes : " + Town.getTowns());
    System.out.print("Quelle ville : ");

    Town town = Town.getTownByName(reader.readLine());

    // check if the town has a station or if it is link to another town with a
    // station thanks to a road
    for (Road road : Road.getRoads()) {
      // TODO
    }

    town.removeStation();
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
