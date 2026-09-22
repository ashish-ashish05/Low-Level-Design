package pricing;

import Entity.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public interface PricingStrategy {

    double calculatePrice(
            Vehicle vehicle,
            LocalDateTime entryTime,
            LocalDateTime exitTime
    );
}