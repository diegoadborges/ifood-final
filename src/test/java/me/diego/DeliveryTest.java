package me.diego;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.diego.domain.Order;
import me.diego.domain.User;
import me.diego.factory.ExpressOrderFactory;
import me.diego.factory.StandardOrderFactory;
import me.diego.ingredients.pizza.PepperoniPizza;
import me.diego.strategy.NoDiscount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeliveryTest {
  private String orderId, restaurantName;
  private User user;
  private Order standardOrder, expressOrder;

  @BeforeEach
  void setUp() {
    this.restaurantName = "restaurant1";
    this.orderId = "0001";
    var noDiscount = new NoDiscount();
    var ingredients = new PepperoniPizza();

    this.standardOrder =
        StandardOrderFactory.getInstance()
            .createOrder(orderId, restaurantName, noDiscount, ingredients);
    this.expressOrder =
        ExpressOrderFactory.getInstance()
            .createOrder(orderId, restaurantName, noDiscount, ingredients);
    this.user = new User("#0001", "user1");
  }

  @Test
  public void shouldNotifyUserWithStandardAndPreparingState() {
    this.user.placeOrder(standardOrder);
    this.standardOrder.preparing();

    var expectedMessage = this.buildExpectedMessage("Pedido em preparação", "STANDARD");

    assertEquals(expectedMessage, user.getLastNotification());
  }

  @Test
  public void shouldNotifyUserWithExpressAndPreparingState() {
    this.user.placeOrder(this.expressOrder);
    this.expressOrder.preparing();

    var expectedMessage = this.buildExpectedMessage("Pedido em preparação", "EXPRESS");

    assertEquals(expectedMessage, user.getLastNotification());
  }

  @Test
  public void shouldNotifyUserWithExpressAndCancelledState() {
    this.user.placeOrder(this.expressOrder);
    this.expressOrder.preparing();

    var expectedMessage = this.buildExpectedMessage("Pedido em preparação", "EXPRESS");

    assertEquals(expectedMessage, user.getLastNotification());

    this.expressOrder.cancel();

    expectedMessage = this.buildExpectedMessage("Pedido cancelado", "EXPRESS");

    assertEquals(expectedMessage, user.getLastNotification());
  }

  private String buildExpectedMessage(String status, String deliveryType) {
    return "Seu pedido #%s-%s do %s está com status: %s"
        .formatted(this.orderId, deliveryType, this.restaurantName, status);
  }
}
