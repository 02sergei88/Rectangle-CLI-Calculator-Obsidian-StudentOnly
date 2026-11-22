package ru.oivt.rectanglecli.util;

import java.util.Scanner;


public final class InputUtils {

    private InputUtils() {
        
    }

    public static double readPositiveDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Ошибка: пустой ввод. Повторите.");
                continue;
            }

            double value;
            try {
                value = Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно число (например 10 или 3.5). Повторите ввод.");
                continue;
            }

            if (value <= 0) {
                System.out.println("Ошибка: значение должно быть > 0. Повторите ввод.");
                continue;
            }

            return value;
        }
    }

    /**
     * Читает целое число. При ошибке — сообщает и повторяет ввод.
     */
    public static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println("Ошибка: пустой ввод. Повторите.");
                continue;
            }

            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: нужно целое число. Повторите ввод.");
            }
        }
    }

    /**
     * Пауза: ждёт, пока пользователь нажмёт Enter.
     */
    public static void pause(Scanner sc) {
        System.out.print("Нажмите Enter, чтобы продолжить...");
        sc.nextLine();
    }
}
