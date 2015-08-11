
package lostinthedark.ui;

import lostinthedark.model.DungeonManager;

public class Main {
  // Replace this with some GUI framework's timing stuff
  // as soon as I have settled for one.
  long timer;
  DungeonManager manager;
  boolean interrupted;

  public Main() {
    manager = new DungeonManager();
  }

  public void start() {
    timer = 0;

    while (timer < 5000) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      timer += 500;

      manager.makeChangesForPassedMs(500);
    }

    System.out.println("Done");
  }

  public static void main(String[] args) {

    new Main().start();
  }
}