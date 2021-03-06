package cs3500.animator.model;

/**
 * Represents a 2D Cartesian position.
 */
public class Position {
  private final int x;
  private final int y;

  /**
   * Constructs a Position.
   *
   * @param x The x coordinate.
   * @param y The y coordinate.
   */
  Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "\tX: " + this.x + "\tY: " + this.y;
  }
}
