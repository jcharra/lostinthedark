package lostinthedark.model;

import java.util.ArrayList;
import java.util.List;

public class Dungeon {
  private List<Room> rooms;

  public Dungeon() {
    rooms = new ArrayList<>();
  }

  public void addRoom(Room r) {
    rooms.add(r);
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void animateObjects(int passedMilliseconds) {
    for (Room r : rooms) {
      for (GameObject obj : r.getObjects()) {
        obj.act(r, passedMilliseconds);
      }
    }
  }
}
