package cs3500.animator.view;

public class SvgView implements IView {

  private double speed;

  public SvgView(double speed) {
    this.speed = speed;
  }

  @Override
  public void runAnimation() {

  }

  @Override
  public double getSpeed() {
    return this.speed;
  }
}
