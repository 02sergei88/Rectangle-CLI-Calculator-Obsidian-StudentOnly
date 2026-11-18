package ru.oivt.rectanglecli.model;

/**
 * Модель прямоугольника: хранит длину a и ширину b,
 * предоставляет методы расчёта характеристик.
 */
public class Rectangle {

    private final double a;
    private final double b;

    public Rectangle(double a, double b) {
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("Стороны должны быть > 0");
        }
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    /** Периметр: P = 2(a + b) */
    public double perimeter() {
        return 2 * (a + b);
    }

    /** Площадь: S = a * b */
    public double area() {
        return a * b;
    }

    /** Диагональ: d = sqrt(a^2 + b^2) */
    public double diagonal() {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * Радиус вписанной окружности: r = a / 2.
     * Существует только для квадрата (a == b с допуском).
     * Если прямоугольник не квадрат — бросаем исключение.
     */
    public double inscribedCircleRadius() {
        if (!isSquare()) {
            throw new IllegalStateException("Вписанная окружность существует только для квадрата");
        }
        return a / 2;
    }

    /** Проверка «квадрат» с допуском (см. Road_Map, шаг 6). */
    public boolean isSquare() {
        final double EPS = 1e-9;
        return Math.abs(a - b) < EPS;
    }
}

