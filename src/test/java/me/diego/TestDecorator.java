package me.diego;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.diego.domain.Order;
import me.diego.factory.OrderFactory;
import me.diego.ingredients.Ingredient;
import me.diego.ingredients.pizza.CheeseBorder;
import me.diego.ingredients.pizza.MargheritaPizza;
import me.diego.ingredients.pizza.PepperoniPizza;
import me.diego.strategy.NoDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestDecorator {
  private String orderId, restaurantName;
  private OrderFactory orderFactory;
  private Ingredient pizza;
  private Order order;

  @BeforeEach
  void setUp() {
    this.restaurantName = "restaurant1";
    this.orderId = "0001";
    this.orderFactory = OrderFactory.getInstance();
    this.pizza = new PepperoniPizza();

    var discount = new NoDiscount();
    this.order =
        orderFactory.createOrder(
            "Express", this.orderId, this.restaurantName, discount, this.pizza);
  }

  @Test
  void testMargheritaPizzaBasics() {
    var pizza = new MargheritaPizza();
    order.setIngredient(pizza);

    assertEquals("Margherita Pizza", order.getDescription());
    assertEquals(20.00, order.getFinalAmount(), 0.01);
  }

  @Test
  void testPepperoniPizzaBasics() {
    var pizza = new PepperoniPizza();
    order.setIngredient(pizza);

    assertEquals("Pepperoni pizza", order.getDescription());
    assertEquals(15.00, order.getFinalAmount(), 0.01);
  }

  @Test
  void testMargheritaWithCheeseBorder() {
    var pizza = new CheeseBorder(new MargheritaPizza());
    order.setIngredient(pizza);

    assertEquals("Margherita Pizza, cheese border", order.getDescription());
    assertEquals(22.00, order.getFinalAmount(), 0.01);
  }
}
