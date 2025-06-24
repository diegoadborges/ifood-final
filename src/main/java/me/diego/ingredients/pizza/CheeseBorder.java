package me.diego.ingredients.pizza;

import me.diego.ingredients.Ingredient;

public class CheeseBorder extends BorderDecorator {
  public CheeseBorder(Ingredient ingredient) {
    super(ingredient);
  }

  @Override
  public String getDescription() {
    return this.ingredient.getDescription() + ", cheese border";
  }

  @Override
  public Double getPrice() {
    return this.ingredient.getPrice() + 2d;
  }
}
