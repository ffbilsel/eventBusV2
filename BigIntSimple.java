import java.math.BigInteger;
import java.util.Scanner;

public class BigIntSimple {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        if (tokens[0].equals("+")) {
            System.out.println(add(tokens[1], tokens[2]));
        }
        else if (tokens[0].equals("-")) {
            System.out.println(subtract(tokens[1], tokens[2]));
        }

        assert subtract("546542132168461121384", "5465464").equals(new BigInteger("546542132168461121384").subtract(new BigInteger("5465464")).toString());
        assert subtract("5465464", "546542132168461121384").equals(new BigInteger("5465464").subtract(new BigInteger("546542132168461121384")).toString());

        System.out.println("ok");
    }

    private static String add(String num1, String num2) {
        String min = num1.length() < num2.length() ? num1 : num2;
        String max = num1.length() < num2.length() ? num2 : num1;
        StringBuilder result = new StringBuilder();
        int remainder = 0;
        for (int i = 1; i <= min.length(); i++) {
            int temp = Character.getNumericValue(min.charAt(min.length() - i)) + Character.getNumericValue(max.charAt(max.length() - i)) + remainder;
            remainder = temp / 10;
            result.append(temp % 10);
        }
        for (int i = min.length() + 1; i <= max.length(); i++) {
            int temp = Character.getNumericValue(max.charAt(max.length() - i)) + remainder;
            remainder = temp / 10;
            result.append(temp % 10);
        }
        return result.reverse().toString();
    }

    private static String subtract(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        StringBuilder min;
        StringBuilder max;
        if (num1.length() > num2.length() || (num1.length() == num2.length() && num1.charAt(0) > num2.charAt(0))) {
            min = new StringBuilder(num2);
            max = new StringBuilder(num1);
        }
        else {
            min = new StringBuilder(num1);
            max = new StringBuilder(num2);
            result.append("-");
        }
        for (int i = 1; i <= min.length(); i++) {
            int temp = Character.getNumericValue(max.charAt(max.length() - i)) - Character.getNumericValue(min.charAt(min.length() - i));
            if (temp > 0) {
                result.append(temp);
            }
            else {
                int counter = 0;
                while (max.length() - i - 1 - counter >= 1 && Character.getNumericValue(max.charAt(max.length() - i - 1 - counter)) == 0) {
                    max.setCharAt(max.length() - i - 1 - counter, '9');
                    counter++;
                }
                result.append(temp + 10);
                max.setCharAt(max.length() - i - 1 - counter, (char)(max.charAt(max.length() - i - 1 - counter) - 1));
            }
        }
        if (max.charAt(0) == '0') {
            max = new StringBuilder(max.substring(1));
        }
        for (int i = max.length() - min.length() - 1; i >= 0; i--) {
            result.append(Character.getNumericValue(max.charAt(i)));
        }
        return result.reverse().toString();
    }
}
