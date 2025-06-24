package me.diego.factory;

import java.lang.reflect.Constructor;
import me.diego.domain.Order;
import me.diego.ingredients.Ingredient;
import me.diego.strategy.DiscountStrategy;

public class OrderFactory {
  private static OrderFactory instance;

  private OrderFactory() {}

  public static OrderFactory getInstance() {
    if (instance == null) {
      instance = new OrderFactory();
    }

    return instance;
  }

  public Order createOrder(
      String type,
      String orderId,
      String restaurantName,
      DiscountStrategy discountStrategy,
      Ingredient ingredient) {
    Class<?> clazz = null;
    Object obj = null;
    try {
      clazz = Class.forName("me.diego.domain." + type + "Order");

      Constructor<?> constructor =
          clazz.getDeclaredConstructor(
              String.class, String.class, DiscountStrategy.class, Ingredient.class);

      obj = constructor.newInstance(orderId, restaurantName, discountStrategy, ingredient);
    } catch (Exception ex) {
      throw new IllegalArgumentException("Invalid order type");
    }
    if (!(obj instanceof Order)) {
      throw new IllegalArgumentException("Invalid order type");
    }
    return (Order) obj;
  }
}
