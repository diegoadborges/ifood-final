package me.diego.domain;

import java.util.Observable;
import me.diego.ingredients.Ingredient;
import me.diego.state.ConfirmedState;
import me.diego.state.OrderState;
import me.diego.strategy.DiscountStrategy;

public abstract class Order extends Observable {
  private String orderId, restaurantName;

  private DiscountStrategy discountStrategy;
  private Ingredient ingredient;

  private OrderState state;

  public Order(
      String orderId,
      String restaurantName,
      DiscountStrategy discountStrategy,
      Ingredient ingredient) {

    this.orderId = orderId;
    this.restaurantName = restaurantName;
    this.state = ConfirmedState.getInstance();
    this.discountStrategy = discountStrategy;
    this.ingredient = ingredient;
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

  public void setDiscount(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;
  }

  public double getFinalAmount() {
    var totalAmount = this.ingredient.getPrice();
    double discount = discountStrategy.calculateDiscount(totalAmount);
    return totalAmount - discount;
  }
}
