package me.diego.ingredients.pizza;

import me.diego.ingredients.Ingredient;

public class PepperoniPizza implements Ingredient {

  @Override
  public Double getPrice() {
    return 15d;
  }

  @Override
  public String getDescription() {
    return "Pepperoni pizza";
  }
}
