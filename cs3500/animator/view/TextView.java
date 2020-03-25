package cs3500.animator.view;

import cs3500.animator.model.Animator;
import javax.swing.JFrame;

public class TextView extends JFrame implements IView {

  private Animator model;
  private double speed;


  public TextView(Animator model, double speed) {
    this.model = model;
    this.speed = speed;
  }

  @Override
  public void runAnimation() {

  }


  public double getSpeed() {
    return speed;
  }
}
