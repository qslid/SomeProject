package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String args[]){
        System.out.println("Hello worlds!");

        Square square = new Square(6);
        Rectangle rectangle = new Rectangle(5,7);

        System.out.println("Площадь квадрата с стороной "+square.lenghtSide +" = " + square.area());
        System.out.println("Площадь прямоугольника с сторонами "+rectangle.lengthSideOne +" и "
                + rectangle.lenghtSideTwo +" = " + rectangle.area());


    }
}
