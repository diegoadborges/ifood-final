package me.diego.ingredients.pizza;

import me.diego.ingredients.Ingredient;

public class MargheritaPizza implements Ingredient {

  @Override
  public Double getPrice() {
    return 20d;
  }

  @Override
  public String getDescription() {
    return "Margherita Pizza";
  }
}
