package lostinthedark.model;

public abstract class Beast extends GameObject {
  public Equipment equipment;
  public Inventory inventory;
  public BeastProperties properties;

  public Beast() {
    super();
  }

  public Equipment getEquipment() {
    return equipment;
  }

  public void setEquipment(Equipment equipment) {
    this.equipment = equipment;
  }

  public Inventory getInventory() {
    return inventory;
  }

  public void setInventory(Inventory inventory) {
    this.inventory = inventory;
  }

  public BeastProperties getProperties() {
    return properties;
  }

  public void setProperties(BeastProperties properties) {
    this.properties = properties;
  }
}
