package cs3500.animator.view;

public interface IView {

  void runAnimation();

  double getSpeed();

  void setSpeed(double newSpeed);

  String viewType();

}
