
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = scanner.nextInt();

        System.out.print("Enter character: ");
        char symbol = scanner.next().charAt(0);

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i <= j && i + j >= n - 1) {
                    matrix[i][j] = symbol;
                } else {
                    matrix[i][j] = ' ';
                }
            }
        }

        System.out.println("Array:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        try (FileWriter writer = new FileWriter("output.txt")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    writer.write(matrix[i][j] + " ");
                }
                writer.write("\n");
            }
            System.out.println("Array is written");
        } catch (IOException e) {
            System.out.println("Error!!!!");
            e.printStackTrace();
        }

        scanner.close();
    }
}
