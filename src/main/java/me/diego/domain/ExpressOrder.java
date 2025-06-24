package me.diego.domain;

import me.diego.ingredients.Ingredient;
import me.diego.strategy.DiscountStrategy;

public class ExpressOrder extends Order {
  public ExpressOrder(
      String orderId,
      String restaurantName,
      DiscountStrategy discountStrategy,
      Ingredient ingredient) {
    super(orderId + "-EXPRESS", restaurantName, discountStrategy, ingredient);
  }
}
