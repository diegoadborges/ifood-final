package me.diego.domain;

import java.util.Observable;
import me.diego.state.ConfirmedState;
import me.diego.state.OrderState;
import me.diego.strategy.DiscountStrategy;

public class Order extends Observable {
  private String orderId, restaurantName;

  private double totalAmount;
  private DiscountStrategy discountStrategy;

  private OrderState state;

  public Order(
      String orderId,
      String restaurantName,
      double totalAmount,
      DiscountStrategy discountStrategy) {
    this.orderId = orderId;
    this.restaurantName = restaurantName;
    this.state = ConfirmedState.getInstance();
    this.totalAmount = totalAmount;
    this.discountStrategy = discountStrategy;
  }

  public boolean confirmed() {
    return this.state.confirmed(this);
  }

  public boolean preparing() {
    return this.state.preparing(this);
  }

  public boolean onTheWay() {
    return this.state.onTheWay(this);
  }

  public boolean delivered() {
    return this.state.delivered(this);
  }

  public boolean cancel() {
    return this.state.cancel(this);
  }

  public void setState(OrderState state) {
    this.state = state;
    this.setChanged();
    this.notifyObservers(
        "Seu pedido #%s do %s está com status: %s"
            .formatted(this.orderId, this.restaurantName, this.state.getDescription()));
  }

  public String getOrderId() {
    return orderId;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public OrderState getState() {
    return state;
  }

  public double getFinalAmount() {
    double discount = discountStrategy.calculateDiscount(totalAmount);
    return totalAmount - discount;
  }
}
