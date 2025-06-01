package me.diego.state;

public class CancelledState extends OrderState {
  CancelledState() {}
  ;

  private static CancelledState instance = new CancelledState();

  public static CancelledState getInstance() {
    return instance;
  }

  @Override
  public String getDescription() {
    return "Pedido cancelado";
  }
}
