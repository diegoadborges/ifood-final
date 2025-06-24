package me.diego.factory;

import me.diego.domain.Order;
import me.diego.ingredients.Ingredient;
import me.diego.strategy.DiscountStrategy;

public interface OrderFactory {
  Order createOrder(
      String orderId,
      String restaurantName,
      DiscountStrategy discountStrategy,
      Ingredient ingredient);
}
