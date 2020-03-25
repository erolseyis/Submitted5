package cs3500.animator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores the KeyFrames that represent the behavior of a particular shape in the animation. More or
 * less a list of KeyFrames, but we maintain the invariant that KeyFrames are sorted by their tick
 * time (ascending), and no two KeyFrames can have the same tick time.
 */
public class Timeline {
  private List<KeyFrame> keyFrames;

  public Timeline() {
    this.keyFrames = new ArrayList<>();
  }

  /**
   * Adds a KeyFrame to the list in the timeline if possible, preserving the invariant that the
   * KeyFrame's in the Timeline are in ascending order by their tick property, and that no two
   * KeyFrame's in a Timeline have the same tick.
   *
   * @param keyFrame The KeyFrame to add.
   * @throws IllegalArgumentException If there's already a KeyFrame at the tick of the given one or
   *                                  if the given KeyFrame is null
   */
  public void addKeyFrame(KeyFrame keyFrame) {
    if (keyFrame == null) {
      throw new IllegalArgumentException("given KeyFrame cannot be null");
    }
    for (KeyFrame kf : keyFrames) {
      if (kf.tick == keyFrame.tick) {
        throw new IllegalArgumentException("cannot add multiple keyframes at the same tick");
      }
    }

    int insertIndex = 0;
    for (int i = 0; i < this.keyFrames.size(); i++, insertIndex++) {
      if (keyFrame.tick < this.keyFrames.get(i).tick) {
        break;
      }
    }
    this.keyFrames.add(insertIndex, keyFrame);
  }

  /**
   * Gets the i-th KeyFrame in the Timeline, allowing any index-related errors to propagate.
   *
   * @param i The index of the timeline.
   * @return The KeyFrame at the i-th place in the Timeline.
   */
  public KeyFrame getKeyFrame(int i) {
    return this.keyFrames.get(i);
  }

  /**
   * Returns the number of KeyFrames in the Timeline.
   *
   * @return However many KeyFrames are in the Timeline.
   */
  public int length() {
    return this.keyFrames.size();
  }
}
