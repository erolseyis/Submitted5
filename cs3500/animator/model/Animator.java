package cs3500.animator.model;

/**
 * Represents an animator tool. For scaling later on.
 */
public interface Animator {

  /**
   * Adds a shape to the animator.
   *
   * @param type The shape to be added.
   * @param name The name of the shape to be added.
   */
  void addShape(ShapeType type, String name);

  /**
   * Adds a KeyFrame to the animator for a specific element of the animation.
   *
   * @param name     The name of the element that a KeyFrame is being inserted for.
   * @param keyFrame The next KeyFrame for the specified element.
   */
  void addKeyFrame(String name, KeyFrame keyFrame);
}

