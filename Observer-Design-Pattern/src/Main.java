import observer.Subscriber;
import observers.EmailSubscriber;
import observers.MobileSubsriber;
import observers.WhatsAppSubscriber;
import subject.YoutubeChannel;


public class Main {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();

        Subscriber emailSubscriber = new EmailSubscriber("user@gmail.com");
        Subscriber mobileSubscriber = new MobileSubsriber("1234567890");
        Subscriber whatsAppSubscriber = new WhatsAppSubscriber("9876543210");

        channel.subscribe(emailSubscriber);
        channel.subscribe(mobileSubscriber);
        channel.subscribe(whatsAppSubscriber);

        channel.uploadVideo("Observer Design Pattern");

        channel.unsubscribe(emailSubscriber);

        channel.uploadVideo("Strategy Design Pattern");
    }
}