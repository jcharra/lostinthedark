package lostinthedark.ui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import lostinthedark.model.Dungeon;
import lostinthedark.model.GameObject;
import lostinthedark.model.Room;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class App extends BasicGame {

  private Dungeon dungeon;

  public App(String gamename) {
    super(gamename);
  }

  public void setDungeon(Dungeon d) {
    this.dungeon = d;
  }

  @Override
  public void init(GameContainer gc) throws SlickException {

  }

  @Override
  public void update(GameContainer gc, int i) throws SlickException {
    List<Room> rooms = dungeon.getRooms();
    for (Room r : rooms) {
      List<GameObject> objs = r.getObjects();
      for (GameObject obj : objs) {
        obj.act(r);
      }
    }
  }

  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException
  {
    g.drawString("Howdy!", 10, 10);
  }

  public static void main(String[] args)
  {
    try
    {
      AppGameContainer appgc;
      App app = new App("Lost in the dark");
      app.setDungeon(new Dungeon());
      appgc = new AppGameContainer(app);
      appgc.setDisplayMode(1200, 800, false);
      appgc.start();
    }
    catch (SlickException ex)
    {
      Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}