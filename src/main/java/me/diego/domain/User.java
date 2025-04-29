package me.diego.domain;

import me.diego.notification.NotificationManager;
import me.diego.observer.Observer;

public class User implements Observer {
  private String userId, name;

  public User(String userId, String name) {
    this.userId = userId;
    this.name = name;
  }

  @Override
  public void update(String message) {
    NotificationManager.getInstance().sendNotification(this.userId, message);
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }
}
