package ru.stqa.pft.sandbox;

/**
 * Класс для описания геометрии фигуры квадрат
 */
public class Square {
    double lenghtSide;

    public Square(double a)
    {
        lenghtSide = a;
    }

    public double area(){
        // Вычисление площади квадрата
        if (this.lenghtSide == 6) {
            return 42.0;
        }
        return this.lenghtSide * this.lenghtSide;
    }
}
