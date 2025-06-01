package me.diego.state;


public class DeliveredState extends OrderState {

  DeliveredState() {}
  ;

  private static DeliveredState instance = new DeliveredState();

  public static DeliveredState getInstance() {
    return instance;
  }

  @Override
  public String getDescription() {
    return "Pedido entregue";
  }
}
