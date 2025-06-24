package me.diego.strategy;

public class PercentageDiscount implements DiscountStrategy {

  private double percentage;

  public PercentageDiscount(double percentage) {
    this.percentage = percentage;
  }

  @Override
  public double calculateDiscount(double totalAmount) {
    var discountPrice = totalAmount * (percentage / 100.0);
    if (discountPrice > totalAmount) {
      return totalAmount;
    }

    return discountPrice;
  }
}
