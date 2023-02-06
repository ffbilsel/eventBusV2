import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.println("Valid characters are alpha numeric (except exit command)");
        System.out.println("Add publisher by : PB <id> <start> <end>");
        System.out.println("This publisher will send the stream of numbers between specified interval when called");
        System.out.println("Add subscriber by : SC <id> -options <pb_ids,>");
        System.out.println("Options are s -> sum of event data, m -> find minimum of event data, M -> find maximum of event data");
        System.out.println("Order of output string is the same with order of the operations");
        System.out.println("To simulate an event : EV <pb_ids,>");
        System.out.println("To exit type :x");
        while (!(line = scanner.nextLine()).contains(":x")) {
            String[] tokens = line.replaceAll("\\s{2,}", " ").split(" ");
            switch (tokens[0]) {
                case "PB" -> EventBus.publishers.put(tokens[1], new Publisher(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])));
                case "SC" -> EventBus.subscribers.put(tokens[1], new Subscriber(tokens[2], Arrays.copyOfRange(tokens, 3, tokens.length)));
                case "EV" -> EventBus.event(Arrays.copyOfRange(tokens, 1, tokens.length));
            }
        }
    }
}
