package me.diego;

import static org.junit.jupiter.api.Assertions.assertEquals;

import me.diego.domain.User;
import me.diego.factory.StandardOrderFactory;
import org.junit.jupiter.api.Test;

public class DeliveryTest {

  @Test
  public void shouldNotifyUser() {
    var resturantName = "restaurant1";
    var orderId = "0001";

    var order = StandardOrderFactory.getInstance().createOrder(orderId, resturantName);
    var user = new User("#0001", "user1");
    user.placeOrder(order);
    order.preparing();

    var expectedMessage =
        "Seu pedido #%s-STANDARD do %s está com status: Pedido em preparação"
            .formatted(orderId, resturantName);

    assertEquals(expectedMessage, user.getLastNotification());
  }
}
