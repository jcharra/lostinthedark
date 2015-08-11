package lostinthedark.model;

import lostinthedark.model.util.Position;

public interface Action {
  GameObject getTarget();
  GameObject getMedium();
  Position getTargetPosition();
  int getDelayMs();
}
