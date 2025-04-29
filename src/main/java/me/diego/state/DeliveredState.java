package me.diego.state;

import me.diego.domain.Order;

public class DeliveredState implements OrderState {

  @Override
  public void nextState(Order order) {
    System.out.println("Pedido entregue, não há próximo estado");
  }

  @Override
  public String getDescription() {
    return "Pedido entregue";
  }
}
