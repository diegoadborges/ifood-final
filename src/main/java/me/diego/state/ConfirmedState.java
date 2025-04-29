package me.diego.state;

import me.diego.domain.Order;

public class ConfirmedState implements OrderState {
  @Override
  public void nextState(Order order) {
    order.setState(new PreparingState());
  }

  @Override
  public String getDescription() {
    return "Pedido confirmado";
  }
}
