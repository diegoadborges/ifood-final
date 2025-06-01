package me.diego.state;


public class OnTheWayState extends OrderState {

  OnTheWayState() {}
  ;

  private static OnTheWayState instance = new OnTheWayState();

  public static OnTheWayState getInstance() {
    return instance;
  }

  @Override
  public String getDescription() {
    return "Pedido a caminho";
  }
}
