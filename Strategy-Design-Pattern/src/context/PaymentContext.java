package context;

import strategy.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void makePayment(double amound){
        if(paymentStrategy==null){
            System.out.println( "Please select a payment method." );
            return;
        }
        paymentStrategy.pay(amound);
    }
}
