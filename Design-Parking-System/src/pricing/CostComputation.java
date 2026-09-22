package pricing;

import Entity.Vehicle;

import java.time.LocalDateTime;

public class CostComputation {

    private final PricingStrategy pricingStrategy;

    public CostComputation(
            PricingStrategy pricingStrategy) {

        this.pricingStrategy = pricingStrategy;
    }

    public double calculateCost(
            Vehicle vehicle,
            LocalDateTime entryTime,
            LocalDateTime exitTime) {

        return pricingStrategy.calculatePrice(
                vehicle,
                entryTime,
                exitTime
        );
    }
}