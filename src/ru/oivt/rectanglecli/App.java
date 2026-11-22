package ru.oivt.rectanglecli;

import java.util.Scanner;

import ru.oivt.rectanglecli.ui.ConsoleUI;


public class App {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            new ConsoleUI(sc).run();
        }
    }
}
