package me.diego.state;

import me.diego.domain.Order;

public abstract class OrderState {
  public abstract String getDescription();

  public boolean confirmed(Order order) {
    return false;
  }

  public boolean preparing(Order order) {
    return false;
  }

  public boolean onTheWay(Order order) {
    return false;
  }

  public boolean delivered(Order order) {
    return false;
  }

  public boolean cancel(Order order) {
    return false;
  }
}
