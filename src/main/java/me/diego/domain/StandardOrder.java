package me.diego.domain;

import me.diego.ingredients.Ingredient;
import me.diego.strategy.DiscountStrategy;

public class StandardOrder extends Order {
  public StandardOrder(
      String orderId,
      String restaurantName,
      DiscountStrategy discountStrategy,
      Ingredient ingredient) {
    super(orderId + "-STANDARD", restaurantName, discountStrategy, ingredient);
  }
}
