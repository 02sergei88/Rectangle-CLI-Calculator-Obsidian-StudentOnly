package ru.oivt.rectanglecli.ui;

import java.util.Locale;
import java.util.Scanner;

import ru.oivt.rectanglecli.model.Rectangle;
import ru.oivt.rectanglecli.util.InputUtils;

public class ConsoleUI {

    private final Scanner sc;

    public ConsoleUI(Scanner sc) {
        this.sc = sc;
    }

    //Точка входа
    public void run() {
        printHeader();

        Rectangle rect = readRectangle();

        boolean running = true;
        while (running) {
            printMenu(rect);
            int choice = InputUtils.readInt(sc, "Ваш выбор: ");

            switch (choice) {
                case 1:
                    showPerimeter(rect);
                    break;
                case 2:
                    showArea(rect);
                    break;
                case 6:
                    rect = readRectangle();
                    break;
                case 0:
                    System.out.println("Выход. До свидания!");
                    running = false;
                    break;
                default:
                    
                    System.out.println("Пункт " + choice + " пока не реализован (появится на шаге 6).");
                    InputUtils.pause(sc);
                    break;
            }
        }
    }

    private void printHeader() {
        System.out.println("========================================");
        System.out.println(" Rectangle CLI Calculator");
        System.out.println("========================================");
        System.out.println();
    }

    
    private Rectangle readRectangle() {
        double a = InputUtils.readPositiveDouble(sc, "Введите длину прямоугольника a: ");
        double b = InputUtils.readPositiveDouble(sc, "Введите ширину прямоугольника b: ");
        return new Rectangle(a, b);
    }

    // Меню: 
    private void printMenu(Rectangle rect) {
        System.out.println("----------------------------------------");
        System.out.printf(Locale.US, "Параметры прямоугольника: a = %.2f, b = %.2f%n",
                rect.getA(), rect.getB());
        System.out.println("----------------------------------------");
        System.out.println("Выберите действие:");
        System.out.println("1) Периметр P = 2(a + b)");
        System.out.println("2) Площадь  S = a * b");
        System.out.println("3) Диагональ d = sqrt(a^2 + b^2)");
        System.out.println("4) Длина описанной окружности C = π * d");
        System.out.println("5) Радиус вписанной окружности (только квадрат)");
        System.out.println("6) Ввести новые параметры");
        System.out.println("0) Выход");
        System.out.println();
    }

    // периметр 
    private void showPerimeter(Rectangle rect) {
        double p = rect.perimeter();
        System.out.println();
        System.out.println("Периметр:");
        System.out.printf(Locale.US, "P = 2(a + b) = 2(%.2f + %.2f) = %.2f%n",
                rect.getA(), rect.getB(), p);
        System.out.println();
        InputUtils.pause(sc);
    }

   // площадь 
    private void showArea(Rectangle rect) {
        double s = rect.area();
        System.out.println();
        System.out.println("Площадь:");
        System.out.printf(Locale.US, "S = a * b = %.2f * %.2f = %.2f%n",
                rect.getA(), rect.getB(), s);
        System.out.println();
        InputUtils.pause(sc);
    }
}


