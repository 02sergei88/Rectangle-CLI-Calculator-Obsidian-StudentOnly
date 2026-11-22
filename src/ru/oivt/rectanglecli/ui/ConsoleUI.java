package ru.oivt.rectanglecli.ui;

import java.util.Scanner;

import ru.oivt.rectanglecli.model.Rectangle;
import ru.oivt.rectanglecli.util.InputUtils;
import java.util.Locale;

public class ConsoleUI {

    private final Scanner sc;

    public ConsoleUI(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        printHeader();

        Rectangle rect = readRectangle();

        boolean running = true;
        while (running) {
            printMenu(rect);
            int choice = InputUtils.readInt(sc, "Ваш выбор: ");

            switch (choice) {
                case 0:
                    System.out.println("Выход. До свидания!");
                    running = false;
                    break;
                case 6:
                    rect = readRectangle();
                    break;
                default:                                                                  
            
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

 
    private void printMenu(Rectangle rect) {
        System.out.println("----------------------------------------");
        System.out.printf(Locale.US,"Параметры прямоугольника: a = %.2f, b = %.2f%n", rect.getA(), rect.getB());
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

}


