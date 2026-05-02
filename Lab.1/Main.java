import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Developer: Perebyinis Artem");
        System.out.println("Variant: 15\n");

        int rows = 3;
        int cols = 3;
        int[][] matrixB = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixB[i][j] = random.nextInt(21) - 10;
            }
        }

        System.out.println("Matrix B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrixB[i][j] + "\t");
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrixB[i][j] > 0 && matrixB[i][j] % 2 == 0) {
                    sum += matrixB[i][j];
                }
            }
        }

        System.out.println("\nSum of positive even elements: " + sum);
    }
}