package me.diego.ingredients.pizza;

import me.diego.ingredients.Ingredient;

public class NoBorder extends BorderDecorator {
  public NoBorder(Ingredient ingredient) {
    super(ingredient);
  }

  @Override
  public String getDescription() {
    return this.ingredient.getDescription() + ", no border";
  }

  @Override
  public Double getPrice() {
    return this.ingredient.getPrice();
  }
}
