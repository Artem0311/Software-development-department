import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Developer: Perebyinis Artem");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input file path: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Enter output file path: ");
        String outputFilePath = scanner.nextLine();

        System.out.println("Processing file...");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = line.replaceAll("\\s+", " ").trim();
                writer.write(processedLine);
                writer.newLine();
            }

            System.out.println("File processing completed successfully.");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
