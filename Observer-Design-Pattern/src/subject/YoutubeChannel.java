package subject;

import observer.Subscriber;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void uploadVideo(String videoTitle) {
        System.out.println("\nNew video uploaded: " + videoTitle);

        notifySubscribers(videoTitle);
    }

    private void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }
}
