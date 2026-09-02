package observers;

import observer.Subscriber;

public class WhatsAppSubscriber implements Subscriber {
    private final String mobileNumber;

    public WhatsAppSubscriber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    @Override
    public void update(String videoTitle) {
        System.out.println("WhatsApp notification sent to " + mobileNumber + ": New video - " + videoTitle);
    }
}
