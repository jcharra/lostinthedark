package lostinthedark.model;

import java.util.UUID;

public abstract class Beast extends GameObject {
  private Equipment equipment;
  private Inventory inventory;
  private BeastProperties properties;
  private UUID id;

  public BeastProperties getProperties() {
    return properties;
  }

  public void setProperties(BeastProperties properties) {
    this.properties = properties;
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

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }
}
