package ru.stqa.pft.sandbox;

public class Point {
/* Класс для работы с точками на плоскости*/
    public int x;
    public int y;

    public Point(int x, int y){
         this.x = x;
         this.y = y;
    }

    public double distance(Point point)
    {
        return Math.sqrt(
                Math.abs(
                        Math.pow(this.x - point.x,2) - Math.pow(this.y - point.y,2)));
    }

}
