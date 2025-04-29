package me.diego.domain;

import me.diego.state.OrderState;

public class Order {
  private OrderState currentState;

  public void setState(OrderState state) {
    this.currentState = state;
  }
}
