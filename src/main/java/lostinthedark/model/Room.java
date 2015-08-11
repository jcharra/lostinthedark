package lostinthedark.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import lostinthedark.model.util.Dimension;
import lostinthedark.model.util.Position;

public class Room {
  private List<Room> exits;
  private List<GameObject> objects;
  private UUID id;
  private Dimension dimension;
  private Map<UUID, Position> positionByObjectId;

  public Room(int width, int height) {
    id = UUID.randomUUID();
    exits = new ArrayList<Room>();
    objects = new ArrayList<GameObject>();
    dimension = new Dimension(width, height);
    positionByObjectId = new HashMap<>();
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

  public void addObject(GameObject object, Position pos) {

    this.objects.add(object);
    positionByObjectId.put(object.getObjId(), pos);
  }

  public Position getPosition(GameObject obj) {
    return positionByObjectId.get(obj);
  }
}
