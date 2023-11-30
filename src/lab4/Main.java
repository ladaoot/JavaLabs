package lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введите размер массива: ");
            int size = scanner.nextInt();

            double[] numbers = new double[size];

            System.out.println("Введите элементы массива:");

            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextDouble();
            }
            double sum = 0;
            try {
                int index = 0;
                while (true) {
                    sum += numbers[index];
                    index++;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.err.println("вы вышли за границу массива");
            }
            finally {
                System.out.println(sum / numbers.length);
            }

        } catch (NegativeArraySizeException e) {
            System.err.println("Размер массива не может быть отрицательным.");
        } catch (InputMismatchException e) {
            System.err.println("Введены некорректные данные. Ожидаются числа.");
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
