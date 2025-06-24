package me.diego.ingredients.pizza;

import me.diego.ingredients.Ingredient;

public abstract class BorderDecorator implements Ingredient {
  protected Ingredient ingredient;

  public BorderDecorator(Ingredient ingredient) {
    this.ingredient = ingredient;
  }

  @Override
  public String getDescription() {
    return this.ingredient.getDescription();
  }

  @Override
  public Double getPrice() {
    return this.ingredient.getPrice();
  }
}
