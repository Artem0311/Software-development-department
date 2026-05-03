import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Developer: Perebyinis Artem");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of sets (N): ");
        int n = scanner.nextInt();
        System.out.print("Enter number of points in each set (M): ");
        int m = scanner.nextInt();

        List<HashSet<Point>> listOfSets = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            HashSet<Point> set = new HashSet<>();
            while (set.size() < m) {
                set.add(new Point(random.nextInt(6), random.nextInt(6)));
            }
            listOfSets.add(set);
            System.out.println("Set " + (i + 1) + ": " + set);
        }

        if (n > 1) {
            HashSet<Point> firstSet = listOfSets.get(0);
            Point mostFrequentPoint = null;
            int maxCount = -1;

            for (Point p : firstSet) {
                int currentCount = 0;
                for (int i = 1; i < n; i++) {
                    if (listOfSets.get(i).contains(p)) {
                        currentCount++;
                    }
                }
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostFrequentPoint = p;
                }
            }

            if (maxCount > 0) {
                System.out.println("Most frequent point from Set 1 in other sets: " + mostFrequentPoint);
                System.out.println("It appears in " + maxCount + " other set(s).");
            } else {
                System.out.println("None of the points from Set 1 appear in any other set.");
            }
        } else {
            System.out.println("Need at least 2 sets to compare.");
        }
        scanner.close();
    }
}