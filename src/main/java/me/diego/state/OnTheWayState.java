package me.diego.state;

import me.diego.domain.Order;

class OnTheWayState implements OrderState {

  @Override
  public void nextState(Order order) {
    order.setState(new DeliveredState());
  }

  @Override
  public String getDescription() {
    return "Pedido a caminho";
  }
}
