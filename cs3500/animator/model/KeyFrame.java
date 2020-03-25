package cs3500.animator.model;

import java.awt.Color;

/**
 * Represents the attributes and location of one of the added shapes at a specific point in time.
 * We assume the that all shapes allowed in an animation can be represented the same way, which
 * allows us to simplify our code considerably. More specifically, we can have the Animator classes
 * deal with the types of shapes being created, while this class just stores their change in state,
 * making things easier.
 */
public class KeyFrame {
  final Color color;
  final int h;
  final int w;
  final Position position;
  final double theta; // We figured this might be useful later on!
  final int tick;

  /**
   * Constructs a KeyFrame.
   *
   * @param color    The color of the shape.
   * @param h        The height of the shape.
   * @param w        The width of the shape.
   * @param position Where the shape should appear on the scene.
   * @param tick     The point in time.
   * @param theta    The angle of the shape, clockwise and with respect to the vertical.
   * @throws IllegalArgumentException If given null arguments or an invalid tick or dimensions.
   */
  public KeyFrame(Color color, int w, int h, Position position, double theta,
      int tick) {
    if (color == null) {
      throw new IllegalArgumentException("color cannot be null");
    }
    if (w < 0) {
      throw new IllegalArgumentException("shape height cannot be negative");
    }
    if (h < 0) {
      throw new IllegalArgumentException("shape width cannot be negative");
    }
    if (position == null) {
      throw new IllegalArgumentException("position cannot be null");
    }
    if (tick < 1) {
      throw new IllegalArgumentException("tick must be positive integer");
    }
    this.color = color;
    this.w = w;
    this.h = h;
    this.position = position;
    this.tick = tick;
    this.theta = theta;
  }

  // Around here, we're going to need a method to interpolate field values at a given tick between
  // this KeyFrame a "next" one in the timeline. It's unnecessary for this assignment.

  @Override
  public String toString() {
    return "Tick: " + this.tick +
        this.position.toString() +
        "\tTheta: " + this.theta +
        "\tHeight: " + this.h +
        "\tWidth: " + this.w +
        "\tColor: " + this.color.toString();
  }
}
