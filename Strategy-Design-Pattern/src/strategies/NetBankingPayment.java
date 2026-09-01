package strategies;

import strategy.PaymentStrategy;

public class NetBankingPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Payment of Rs." + amount + " made using Net Banking Payment.");

    }
}
