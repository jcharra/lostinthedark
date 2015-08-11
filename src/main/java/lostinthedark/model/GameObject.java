package lostinthedark.model;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.UUID;

public abstract class GameObject {
  private UUID objId;
  private long clock;
  private Queue<Action> pendingAction;

  public GameObject() {
    objId = UUID.randomUUID();
    clock = 0;
    pendingAction = new ArrayDeque<>();
  }

  public UUID getObjId() {
    return objId;
  }

  /**
   * Objects will be asked to act, given their current context (i.e. a room).
   * The number of milliseconds that have passed since the last call must be specified.
   */
  public void act(Room r, int millisecondsPassed) {
    clock += millisecondsPassed;

    if (!pendingAction.isEmpty()) {
      Action next = pendingAction.remove();
      if (next.getDelayMs() <= clock) {
        clock -= next.getDelayMs();
        execute(next);
      }
    }
  }

  protected abstract void execute(Action next);

  protected void scheduleAction(Action a) {
    pendingAction.add(a);
  }
}
