package me.diego.factory;

import me.diego.domain.Order;
import me.diego.ingredients.Ingredient;
import me.diego.strategy.DiscountStrategy;

public class ExpressOrderFactory implements OrderFactory {
  private static ExpressOrderFactory instance;

  private ExpressOrderFactory() {}

  public static ExpressOrderFactory getInstance() {
    if (instance == null) {
      instance = new ExpressOrderFactory();
    }

    return instance;
  }

  @Override
  public Order createOrder(
      String orderId,
      String restaurantName,
      DiscountStrategy discountStrategy,
      Ingredient ingredient) {
    var order = new Order(orderId + "-EXPRESS", restaurantName, discountStrategy, ingredient);
    return order;
  }
}
