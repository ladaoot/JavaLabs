package lab4;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class FileCopy {

    public static void main(String[] args) {
        try {
            File currentFile = new File("/home/ladach/ИТиП/labs/src/lab4/one.txt");
            File file = new File("/home/ladach/ИТиП/labs/src/lab4/new.txt");
            Scanner scanner = new Scanner(currentFile);
            try {
                FileWriter writer = new FileWriter(file);
                while (scanner.hasNextLine()) {
                    writer.write(scanner.nextLine());
                    writer.write("\n");
                }
                writer.close();
                scanner.close();
            } catch (IOException e) {
                System.err.println("ошибка при записи файла");
            }

        } catch (FileNotFoundException e) {
            System.err.println("файл не найден");
        }
    }
}
