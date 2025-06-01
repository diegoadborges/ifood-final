package me.diego.state;

import me.diego.domain.Order;

public class ConfirmedState extends OrderState {

  ConfirmedState() {}
  ;

  private static ConfirmedState instance = new ConfirmedState();

  public static ConfirmedState getInstance() {
    return instance;
  }

  @Override
  public boolean cancel(Order order) {
    order.setState(CancelledState.getInstance());
    return true;
  }

  @Override
  public boolean preparing(Order order) {
    order.setState(PreparingState.getInstance());
    return true;
  }

  @Override
  public String getDescription() {
    return "Pedido confirmado";
  }
}
