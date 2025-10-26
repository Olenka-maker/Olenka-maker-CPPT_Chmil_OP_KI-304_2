package lab5;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the value of x: ");
        double x = scanner.nextDouble();

        try {
            double y = Calculate.compute(x);

            writeTextResult("result.txt", x, y);
            writeBinaryResult("result.dat", x, y);

            System.out.println("Computation result written to result.txt and result.dat");

            System.out.println("Reading from text file:");
            FileReaderWriter.readTextResult("result.txt");

            System.out.println("Reading from binary file:");
            FileReaderWriter.readBinaryResult("result.dat");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File writing/reading error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }


    public static void writeTextResult(String fileName, double x, double y) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            writer.println("Result of the computation for x = " + x + " : y = " + y);
        }
    }

    public static void writeBinaryResult(String fileName, double x, double y) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeDouble(x);
            dos.writeDouble(y);
        }
    }
}
