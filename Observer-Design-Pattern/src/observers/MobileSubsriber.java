package observers;

import observer.Subscriber;

public class MobileSubsriber implements Subscriber {
    private final String mobileNumber;

    public MobileSubsriber(String mobileNumber){
        this.mobileNumber = mobileNumber;
    }


    @Override
    public void update(String videoTitle) {
        System.out.println("Mobile notification sent to " + mobileNumber + ": New video - " + videoTitle);
    }
}
