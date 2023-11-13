package up.mi.projet.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

      // create menu
      System.out.println("1 - Ajouter une route");
      System.out.println("2 - fin");

    } catch (Exception e) {
      e.printStackTrace(System.err);
    }

  }
}
