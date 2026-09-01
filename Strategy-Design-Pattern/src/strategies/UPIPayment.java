package strategies;

import strategy.PaymentStrategy;

public class UPIPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using UPI.");
    }
}
