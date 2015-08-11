package lostinthedark.model;

public class DungeonManager {
  private Dungeon dungeon;

  public DungeonManager() {
    dungeon = new Dungeon();
    Room room1 = new Room(50, 50);
    dungeon.addRoom(room1);
  }

  public void makeChangesForPassedMs(int i) {
    dungeon.animateObjects(i);
  }
}
