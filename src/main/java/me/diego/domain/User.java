package me.diego.domain;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer {
  private String userId, name, lastNotification;

  public User(String userId, String name) {
    this.userId = userId;
    this.name = name;
  }

  public void placeOrder(Order order) {
    order.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    this.lastNotification = (String) arg;
  }

  public String getLastNotification() {
    return this.lastNotification;
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }
}
