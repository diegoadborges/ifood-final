package me.diego.strategy;

public class FixedDiscount implements DiscountStrategy {

  private double discountAmount;

  public FixedDiscount(double discountAmount) {
    this.discountAmount = discountAmount;
  }

  @Override
  public double calculateDiscount(double totalAmount) {
    return Math.min(totalAmount, discountAmount);
  }
}
