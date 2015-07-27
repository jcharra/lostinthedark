package model;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.newdawn.slick.SlickException;
import lostinthedark.model.BeastProperties;
import lostinthedark.model.Dungeon;
import lostinthedark.model.GameObject;
import lostinthedark.model.Juggernaut;
import lostinthedark.model.Room;
import lostinthedark.ui.App;

public class TestAssembly {
  @Test
  public void testRoomPopulation() {
    Room r = new Room(10, 10);

    BeastProperties props = new BeastProperties();
    Juggernaut jug = new Juggernaut();
    jug.setProperties(props);
    r.addObject(jug);

    List<GameObject> beasts = r.getObjects();
    assertEquals(beasts.get(0), jug);
  }

  @Test
  public void testEntityUpdate() throws SlickException {
    App app = new App("test");
    Room r = new Room(1, 1);
    Dungeon d = new Dungeon();
    d.addRoom(r);
    app.setDungeon(d);

    // Detached game object will not be updated
    GameObject detachedMock = createMock(GameObject.class);
    replay(detachedMock);
    app.update(null, 0);
    verify(detachedMock);

    // Inside a room it will be updated
    GameObject mockInGame = createMock(GameObject.class);
    r.addObject(mockInGame);
    mockInGame.act(r);
    replay(mockInGame);
    app.update(null, 0);
    verify(mockInGame);
  }
}
