package me.diego.domain;

import java.util.ArrayList;
import java.util.List;
import me.diego.observer.Observer;
import me.diego.observer.Subject;
import me.diego.state.ConfirmedState;
import me.diego.state.OrderState;

public class Order implements Subject {
  private String orderId, restaurantName;

  private OrderState currentState;
  private List<Observer> observers = new ArrayList<>();

  public Order(String orderId, String restaurantName) {
    this.orderId = orderId;
    this.restaurantName = restaurantName;
    this.currentState = new ConfirmedState();
  }

  public void setState(OrderState state) {
    this.currentState = state;
    this.notifyObservers(
        "Seu pedido #%s do %s está com status: %s"
            .formatted(this.orderId, this.restaurantName, this.currentState.getDescription()));
  }

  public void progressToNextState() {
    this.currentState.nextState(this);
  }

  @Override
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  @Override
  public void removeObserver(Observer observer) {
    observers.remove(observer);
  }

  @Override
  public void notifyObservers(String message) {
    for (Observer observer : observers) {
      observer.update(message);
    }
  }

  public String getOrderId() {
    return orderId;
  }

  public String getRestaurantName() {
    return restaurantName;
  }

  public OrderState getCurrentState() {
    return currentState;
  }
}
