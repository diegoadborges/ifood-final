package me.diego.state;

import me.diego.domain.Order;

public interface OrderState {
  void nextState(Order order);

  String getDescription();
}
