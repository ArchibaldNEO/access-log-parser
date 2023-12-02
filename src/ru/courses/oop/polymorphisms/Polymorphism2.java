package ru.courses.oop.polymorphisms;

public class Polymorphism2 extends PolyLine implements Polymorphism3{

  public Polymorphism2(Point[] points) {
    super(points);
  }

  public double lenght1() {
    double sum, X, Y;
    X = points[points.length - 1].x - points[0].x;
    Y = points[points.length - 1].y - points[0].y;
    sum = Math.sqrt(X * X + Y * Y);

    return sum + lenght();
  }
}
