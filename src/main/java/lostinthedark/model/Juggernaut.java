package lostinthedark.model;

public class Juggernaut extends Beast {

  @Override
  public void act(Room r) {
    if (r.getExits().size() == 0) {
      grunt();
    }
  }

  public void grunt() {

  }
}
