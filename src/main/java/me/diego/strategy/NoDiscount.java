package me.diego.strategy;

public class NoDiscount implements DiscountStrategy {

  @Override
  public double calculateDiscount(double totalAmount) {
    return 0;
  }
}
