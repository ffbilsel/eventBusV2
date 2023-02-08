import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       Dict dict = new Dict();
       while (true) {
           String[] tokens = scanner.nextLine().split(" ");
           if (tokens[0].equals("put")) {
               dict.put(tokens[1], Integer.parseInt(tokens[2]));
           }
           else if (tokens[0].equals("get")) {
               System.out.println(dict.get(tokens[1]));
           }
       }
    }
}
