package lostinthedark.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lostinthedark.model.util.Dimension;

public class Room {
  private List<Room> exits;
  private List<GameObject> objects;
  private UUID id;
  private Dimension dimension;

  public Room(int width, int height) {
    id = UUID.randomUUID();
    exits = new ArrayList<Room>();
    objects = new ArrayList<GameObject>();
    dimension = new Dimension(width, height);
  }

  public Dimension getDimension() {
    return dimension;
  }

  public UUID getId() {
    return id;
  }

  public List<Room> getExits() {
    return exits;
  }

  public void addExit(Room exit) {
    this.exits.add(exit);
  }

  public List<GameObject> getObjects() {
    return objects;
  }

  public void addObject(GameObject object) {
    this.objects.add(object);
  }
}
