package up.mi.projet.main.agglomeration;

public class Road {
  private Town origin;
  private Town destination;

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
}
