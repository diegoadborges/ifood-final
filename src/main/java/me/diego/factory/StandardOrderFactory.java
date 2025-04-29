package me.diego.factory;

import me.diego.domain.Order;

public class StandardOrderFactory implements OrderFactory {
  @Override
  public Order createOrder(String orderId, String restaurantName) {
    var order = new Order(orderId, restaurantName);
    System.out.println("Criando pedido padrão");
    return order;
  }
}
