package me.diego.state;

import me.diego.domain.Order;

public class PreparingState extends OrderState {

  PreparingState() {}
  ;

  private static PreparingState instance = new PreparingState();

  public static PreparingState getInstance() {
    return instance;
  }

  @Override
  public boolean cancel(Order order) {
    order.setState(CancelledState.getInstance());
    return true;
  }

  @Override
  public boolean onTheWay(Order order) {
    order.setState(OnTheWayState.getInstance());
    return true;
  }

  @Override
  public String getDescription() {
    return "Pedido em preparação";
  }
}
