package lostinthedark.model;

public abstract class GameObject {
  private double weight;

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * Objects will be asked to act, given their current context (i.e. a room)
   */
  public abstract void act(Room r);
}
