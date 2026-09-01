package strategies;

import strategy.PaymentStrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using Credit Card.");
    }
}
