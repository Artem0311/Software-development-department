import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Developer: Perebyinis Artem");
        System.out.println("Variant: 15");

        Random random = new Random();
        int number = 1000 + random.nextInt(9000);
        String s = Integer.toString(number);
        System.out.println("Generated number: " + s);

        if (s.length() >= 2) {
            int firstDigit = Character.getNumericValue(s.charAt(0));
            int modifiedDigit = (firstDigit + 3) % 10;
            String result1 = s.substring(0, 1) + modifiedDigit + s.substring(2);
            System.out.println("Task 1 Result: " + result1);
        }

        String text = "Java is a high-level class-based object-oriented programming language that is designed to have as few implementation dependencies as possible.";
        System.out.println("Original text: " + text);

        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        int maxLength = 0;
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        System.out.print("Task 2 Result (Max length words): ");
        for (String word : words) {
            if (word.length() == maxLength) {
                System.out.print(word + " ");
            }
        }
        System.out.println();
    }
}