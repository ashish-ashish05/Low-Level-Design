package payment;

public class CashPayment implements Payment {

    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount +
                        " made using Cash"
        );

        return true;
    }
}