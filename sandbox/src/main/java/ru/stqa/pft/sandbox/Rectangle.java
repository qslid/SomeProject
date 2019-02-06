package ru.stqa.pft.sandbox;

/**
 * Класс описывающий прямоугольник
 */
public class Rectangle {
    double lengthSideOne;
    double lenghtSideTwo;

    public Rectangle(double a,double b){
        lengthSideOne = a;
        lenghtSideTwo = b;
    }

    public double area(){
        //вычисление площади прямоугольника
        return this.lengthSideOne * this.lenghtSideTwo;
    }
}
