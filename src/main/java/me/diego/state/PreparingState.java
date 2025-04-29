package me.diego.state;

import me.diego.domain.Order;

public class PreparingState implements OrderState {

  @Override
  public void nextState(Order order) {
    order.setState(new ReadyForDeliveryState());
  }

  @Override
  public String getDescription() {
    return "Pedido em preparação";
  }
}
