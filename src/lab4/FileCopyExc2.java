package lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class FileCopyExc2 {
    public static void main(String[] args) {
        try {
            File currentFile = new File("/home/ladach/ИТиП/labs/src/lab4/one.txt");
            File file = new File("/home/ladach/ИТиП/labs/src/lab4/new.txt");
            Scanner scanner = new Scanner(currentFile);
            try {
                FileWriter writer = new FileWriter(file);
                writer.close();
                while (scanner.hasNextLine()) {
                    writer.write(scanner.nextLine());
                    writer.write("\n");
                }
                writer.close();
                scanner.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (
                FileNotFoundException e) {
            System.err.println("файл не найден");
        }
    }
}
