package lostinthedark.model.util;

public class Dimension {
  private int width;
  private int height;

  public Dimension(int w, int h) {
    width = w;
    height = h;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
