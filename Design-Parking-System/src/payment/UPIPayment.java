package payment;

public class UPIPayment implements Payment {

    @Override
    public boolean pay(double amount) {

        System.out.println(
                "Payment of ₹" + amount +
                        " made using UPI"
        );

        return true;
    }
}