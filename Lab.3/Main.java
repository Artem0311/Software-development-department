import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

class Teacher {
    private String surname;
    private String gender;
    private String[] subjects;
    private String department;
    private String position;

    public Teacher(String surname, String gender, String[] subjects, String department, String position) {
        this.surname = surname;
        this.gender = gender;
        this.subjects = subjects;
        this.department = department;
        this.position = position;
    }

    public String getGender() { return gender; }
    public String[] getSubjects() { return subjects; }
    public String getDepartment() { return department; }
    public String getPosition() { return position; }

    public void printRow() {
        String subjectsStr = String.join(", ", subjects);
        System.out.printf("| %-15s | %-10s | %-30s | %-20s | %-25s |%n", 
            surname, gender, subjectsStr, department, position);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Perebyinis Artem\n");

        Teacher[] teachers = {
            new Teacher("Smith", "Male", new String[]{"Math", "Physics"}, "Science", "Professor"),
            new Teacher("Johnson", "Female", new String[]{"Biology"}, "Science", "Associate Professor"),
            new Teacher("Williams", "Female", new String[]{"Literature", "English"}, "Arts", "Associate Professor"),
            new Teacher("Brown", "Male", new String[]{"History"}, "Arts", "Assistant"),
            new Teacher("Jones", "Female", new String[]{"Math", "CS"}, "Science", "Associate Professor")
        };

        printTable(teachers);

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            try {
                System.out.println("\nSelect an action:");
                System.out.println("1. Find teachers by department");
                System.out.println("2. Find teachers by subject");
                System.out.println("3. Find female associate professors");
                System.out.println("0. Exit");
                System.out.print("Your choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 0) break;

                switch (choice) {
                    case 1:
                        System.out.print("Enter department (e.g., Science, Arts): ");
                        String dept = scanner.nextLine();
                        findByDepartment(teachers, dept);
                        break;
                    case 2:
                        System.out.print("Enter subject (e.g., Math, History): ");
                        String subj = scanner.nextLine();
                        findBySubject(teachers, subj);
                        break;
                    case 3:
                        findFemaleAssociateProfessors(teachers);
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input error! Please enter a valid integer.");
                scanner.nextLine(); 
            }
        }
        scanner.close();
    }

    private static void printTable(Teacher[] array) {
        if (array.length == 0) {
            System.out.println("No data found for this search criteria.");
            return;
        }
        System.out.println(new String(new char[115]).replace("\0", "-"));
        System.out.printf("| %-15s | %-10s | %-30s | %-20s | %-25s |%n", 
            "Surname", "Gender", "Subjects", "Department", "Position");
        System.out.println(new String(new char[115]).replace("\0", "-"));
        for (Teacher t : array) {
            t.printRow();
        }
        System.out.println(new String(new char[115]).replace("\0", "-"));
    }

    private static void findByDepartment(Teacher[] teachers, String department) {
        Teacher[] result = Arrays.stream(teachers)
            .filter(t -> t.getDepartment().equalsIgnoreCase(department))
            .toArray(Teacher[]::new);
        printTable(result);
    }

    private static void findBySubject(Teacher[] teachers, String subject) {
        Teacher[] result = Arrays.stream(teachers)
            .filter(t -> Arrays.stream(t.getSubjects()).anyMatch(s -> s.equalsIgnoreCase(subject)))
            .toArray(Teacher[]::new);
        printTable(result);
    }

    private static void findFemaleAssociateProfessors(Teacher[] teachers) {
        Teacher[] result = Arrays.stream(teachers)
            .filter(t -> t.getGender().equalsIgnoreCase("Female") && t.getPosition().equalsIgnoreCase("Associate Professor"))
            .toArray(Teacher[]::new);
        printTable(result);
    }
}