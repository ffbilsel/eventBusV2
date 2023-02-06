import java.util.List;

public class Subscriber {

    List<String> publishers;
    List<String> actions;

    public Subscriber(String rawOptions, String[] publishers) {
        actions = List.of(rawOptions.replace("-", "").split(""));
        this.publishers = List.of(String.join("", publishers).split(","));
    }

    public void event(String id, String publisherId, Publisher publisher) {
        for (String action : actions) {
            switch (action) {
                case "s" -> System.out.printf("Subscriber with id : %s responded %d of publisher with id %s",
                        id, ((publisher.getStart() + publisher.getEnd()) * (publisher.getEnd() - publisher.getStart()) / 2 - 1), publisherId);
                case "m" -> System.out.println(publisher.getStart());
                case "M" -> System.out.println(publisher.getEnd());
            }
        }
    }
}
