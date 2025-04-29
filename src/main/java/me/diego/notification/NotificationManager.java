package me.diego.notification;

public class NotificationManager {
  private static NotificationManager instance;

  private NotificationManager() {}

  public static NotificationManager getInstance() {
    if (instance == null) {
      instance = new NotificationManager();
    }

    return instance;
  }

  public void sendNotification(String userId, String message) {
    System.out.println("[NOTIFICAÇÃO para %s]: %s".formatted(userId, message));
  }
}
