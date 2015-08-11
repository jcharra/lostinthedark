package model;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import lostinthedark.model.Dungeon;
import lostinthedark.model.GameObject;
import lostinthedark.model.Room;
import lostinthedark.model.util.Position;

import org.junit.Test;

public class TestAssembly {
  @Test
  public void testRoomPopulation() {
    Room r = new Room(10, 10);

    GameObject obj = createMock(GameObject.class);
    r.addObject(obj, new Position(5, 5, 0));

    List<GameObject> beasts = r.getObjects();
    assertEquals(beasts.get(0), obj);
  }

  @Test
  public void testEntityUpdate() {
    Room r = new Room(1, 1);
    Dungeon d = new Dungeon();
    d.addRoom(r);

    // Detached game object will not be updated
    GameObject detachedMock = createMock(GameObject.class);
    replay(detachedMock);
    d.animateObjects(10);
    verify(detachedMock);

    // Inside a room it will be updated
    GameObject mockInGame = createMock(GameObject.class);
    expect(mockInGame.getObjId()).andReturn(UUID.randomUUID()).anyTimes();
    mockInGame.act(r, 50);

    replay(mockInGame);

    r.addObject(mockInGame, new Position(5, 5, 0));
    d.animateObjects(50);

    verify(mockInGame);
  }
}
