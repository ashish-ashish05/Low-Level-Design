package pricing;

import Entity.Vehicle;

import java.time.LocalDateTime;

public class FixedPricingStrategy
        implements PricingStrategy {

    private final double fixedPrice;

    public FixedPricingStrategy(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    @Override
    public double calculatePrice(
            Vehicle vehicle,
            LocalDateTime entryTime,
            LocalDateTime exitTime) {

        return fixedPrice;
    }
}