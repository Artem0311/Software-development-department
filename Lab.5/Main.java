import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Searchable {
    void searchByLine(String line);
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Developer: Perebyinis Artem\n");

        Scanner scanner = new Scanner(System.in);
        TransportService service = new TransportService("City Transport Directory");

        System.out.print("Enter number of records to add: ");
        int n = 0;
        try {
            n = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Setting to 0.");
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Entering record " + (i + 1) + ":");
            System.out.print("Enter route line: ");
            String line = scanner.nextLine();
            
            System.out.print("Enter operation time: ");
            String time = scanner.nextLine();
            
            System.out.print("Enter cost: ");
            double cost = 0.0;
            try {
                cost = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid cost. Setting to 0.0");
            }

            service.addRecord(line, time, cost);
        }

        service.displayRecords();

        System.out.print("Enter route line to search: ");
        String searchLine = scanner.nextLine();
        service.searchByLine(searchLine);

        scanner.close();
        System.out.println("System shut down.");
    }
}

class TransportService implements Searchable {
    private String name;
    private List<Record> records;

    public TransportService(String name) {
        this.name = name;
        this.records = new ArrayList<>();
        System.out.println("Action: Transport service initialized.");
    }

    public void addRecord(String line, String time, double cost) {
        Record newRecord = new Record(line, time, cost);
        records.add(newRecord);
        System.out.println("Action: Record added to service.");
    }

    public void displayRecords() {
        System.out.println("\nAll transport records:");
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Record record : records) {
                System.out.println(record.getDetails());
            }
        }
        System.out.println();
    }

    @Override
    public void searchByLine(String line) {
        System.out.println("Action: Searching for route line [" + line + "]");
        boolean found = false;
        for (Record record : records) {
            if (record.getLine().equalsIgnoreCase(line.trim())) {
                System.out.println("Found: " + record.getDetails());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Result: Route not found.");
        }
    }

    class Record {
        private String line;
        private String time;
        private double cost;

        public Record(String line, String time, double cost) {
            this.line = line;
            this.time = time;
            this.cost = cost;
            System.out.println("Action: Inner class Record created for line " + line);
        }

        public String getLine() {
            return line;
        }

        public String getDetails() {
            return "Line: " + line + ", Time: " + time + ", Cost: " + cost;
        }
    }
}