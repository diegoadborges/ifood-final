package me.diego.factory;

import me.diego.domain.Order;

public class ExpressOrderFactory implements OrderFactory {

  @Override
  public Order createOrder(String orderId, String restaurantName) {
    var order = new Order(orderId + "-EXPRESS", restaurantName);
    System.out.println("Criando pedido expresso");
    return order;
  }
}
