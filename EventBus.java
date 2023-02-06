import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventBus {


    public static Map<String, Publisher> publishers = new HashMap<>();
    public static Map<String, Subscriber> subscribers = new HashMap<>();

    public static void event(String[] tokens) {
        List<String> publishers = List.of(String.join("", tokens).split(","));
        for (Map.Entry<String, Subscriber> subscriber: subscribers.entrySet()) {
            for (String publisher : publishers) {
                if (subscriber.getValue().publishers.contains(publisher)) {
                    subscriber.getValue().event(subscriber.getKey(), publisher, EventBus.publishers.get(publisher));
                }
            }
        }
    }

}
