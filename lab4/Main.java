import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter writer = null;

      
        System.out.print("Enter the value of x: ");
        double x = scanner.nextDouble();

        try {
            
            double y = Calculate.compute(x);
            
            writer = new PrintWriter(new FileWriter("result.txt"));
            writer.println("Result of the computation for x = " + x + " : y = " + y);
            System.out.println("Computation result written to result.txt");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File writing error: " + e.getMessage());
        } finally {
            if (writer != null) {
                writer.close(); 
            }
            scanner.close(); 
        }
    }
}
