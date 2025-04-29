package me.diego.factory;

import me.diego.domain.Order;

public interface OrderFactory {
  Order createOrder(String orderId, String restaurantName);
}
