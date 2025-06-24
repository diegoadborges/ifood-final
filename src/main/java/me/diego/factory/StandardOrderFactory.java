package me.diego.factory;

import me.diego.domain.Order;
import me.diego.ingredients.Ingredient;
import me.diego.strategy.DiscountStrategy;

public class StandardOrderFactory implements OrderFactory {
  private static StandardOrderFactory instance;

  private StandardOrderFactory() {}

  public static StandardOrderFactory getInstance() {
    if (instance == null) {
      instance = new StandardOrderFactory();
    }

    return instance;
  }

  @Override
  public Order createOrder(
      String orderId,
      String restaurantName,
      DiscountStrategy discountStrategy,
      Ingredient ingredient) {
    var order = new Order(orderId + "-STANDARD", restaurantName, discountStrategy, ingredient);
    return order;
  }
}
