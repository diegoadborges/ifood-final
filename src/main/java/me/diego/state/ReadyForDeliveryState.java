package me.diego.state;

import me.diego.domain.Order;

public class ReadyForDeliveryState implements OrderState {

  @Override
  public void nextState(Order order) {
    order.setState(new PickedUpState());
  }

  @Override
  public String getDescription() {
    return "Pedido pronto para entrega";
  }
}
