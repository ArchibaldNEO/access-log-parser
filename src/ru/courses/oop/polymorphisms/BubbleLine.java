package ru.courses.oop.polymorphisms;

public class BubbleLine extends PolyLine {

  public BubbleLine(Point[] points) {
    super(points);
  }

  public double lenght() {
    double sum, X, Y;
    X = points[points.length - 1].x - points[0].x;
    Y = points[points.length - 1].y - points[0].y;
    sum = Math.sqrt(X * X + Y * Y);

    return sum + lenght();
  }
}
