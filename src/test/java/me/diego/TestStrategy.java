package me.diego;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.diego.domain.Order;
import me.diego.factory.OrderFactory;
import me.diego.ingredients.Ingredient;
import me.diego.ingredients.pizza.PepperoniPizza;
import me.diego.strategy.FixedDiscount;
import me.diego.strategy.NoDiscount;
import me.diego.strategy.PercentageDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestStrategy {
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
  public void shouldApplyNoDiscount() {
    var discount = new NoDiscount();
    order.setDiscount(discount);
    assertEquals(order.getFinalAmount(), 15d);
  }

  @Test
  public void shouldApply10PercentDiscount() {
    var discount = new PercentageDiscount(10);
    order.setDiscount(discount);
    assertEquals(order.getFinalAmount(), 13.5);
  }

  @Test
  public void shouldApply100PercentDiscount() {
    var discount = new PercentageDiscount(100);
    order.setDiscount(discount);
    assertEquals(order.getFinalAmount(), 0);
  }

  @Test
  public void shouldNotBeNegativeWithPercentageDiscountBiggerThanTotalValue() {
    var discount = new PercentageDiscount(101);
    order.setDiscount(discount);
    assertEquals(order.getFinalAmount(), 0);
  }

  @Test
  public void shouldApplyFixed5Discount() {
    var discount = new FixedDiscount(5);
    order.setDiscount(discount);
    assertEquals(order.getFinalAmount(), 10);
  }

  @Test
  public void shouldApplyFixed15Discount() {
    var discount = new FixedDiscount(15);
    order.setDiscount(discount);
    assertEquals(order.getFinalAmount(), 0);
  }

  @Test
  public void shouldNotBeNegativeWithFixedDiscountBiggerThanTotalValue() {
    var discount = new FixedDiscount(20);
    order.setDiscount(discount);
    assertEquals(order.getFinalAmount(), 0);
  }
}
