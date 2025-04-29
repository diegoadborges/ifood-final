package me.diego.state;

import me.diego.domain.Order;

public class PickedUpState implements OrderState {

  @Override
  public void nextState(Order order) {
    order.setState(new OnTheWayState());
  }

  @Override
  public String getDescription() {
    return "Pedido retirado pelo entregador";
  }
}
