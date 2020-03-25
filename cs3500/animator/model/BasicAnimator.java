package cs3500.animator.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents an animator that only uses ellipses and rectangles.
 */
public class BasicAnimator implements Animator {
  // The named shapes that have been created
  Map<String, ShapeType> shapes;
  // The key points in the animation for each shape created
  Map<String, Timeline> shapeTimelines;
  // A more advanced animator might store a list of shape names (String) representing their layering
  // order. However, it's not necessary for a basicAnimator.

  /**
   * Constructs a BasicAnimator.
   */
  public BasicAnimator() {
    this.shapes = new HashMap<>();
    this.shapeTimelines = new HashMap<>();
  }

  @Override
  public void addShape(ShapeType type, String name) {
    if (type == null) {
      throw new IllegalArgumentException("shape type cannot be null");
    }

    if (name == null || name.equals("")) {
      throw new IllegalArgumentException("name cannot be null or the empty string");
    }

    if (this.shapes.containsKey(name)) {
      throw new IllegalArgumentException("shape with given name already exists");
    }

    this.shapes.put(name, type);
    this.shapeTimelines.put(name, new Timeline());
  }

  @Override
  public void addKeyFrame(String name, KeyFrame keyFrame) {
    if (name == null) {
      throw new IllegalArgumentException("name cannot be null");
    }

    if (!this.shapes.containsKey(name)) {
      throw new IllegalArgumentException("shape with given name does not exist");
    }

    this.shapeTimelines.get(name).addKeyFrame(keyFrame);
  }

  @Override
  public String toString() {
    StringBuilder output = new StringBuilder();
    for (String name : this.shapes.keySet()) {
      output.append("shape " + name + " " + this.shapes.get(name).toString() + "\n");
      for (int i = 1; i < shapeTimelines.get(name).length(); i++) {
        output.append("motion " + name + "\n");
        output.append("start:\t");
        output.append(this.shapeTimelines.get(name).getKeyFrame(i - 1).toString());
        output.append("\n");
        output.append("end:\t");
        output.append(this.shapeTimelines.get(name).getKeyFrame(i).toString());
        output.append("\n");
      }
    }
    return output.toString();
  }

  // A more complex animator could implement convenience methods such as "doNothing" that finds
  // the last KeyFrame and adds a KeyFrame with the same state at a tick which is necessarily
  // larger than the last KeyFrame's tick, essentially making the shape not change until the
  // given tick.
}

