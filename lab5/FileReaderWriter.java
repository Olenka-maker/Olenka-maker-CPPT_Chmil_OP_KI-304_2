package lab5;

import java.io.*;

public class FileReaderWriter {

    public static void readTextResult(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void readBinaryResult(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            double x = dis.readDouble();
            double y = dis.readDouble();
            System.out.println("Read from binary file - x: " + x + ", y: " + y);
        }
    }
}
