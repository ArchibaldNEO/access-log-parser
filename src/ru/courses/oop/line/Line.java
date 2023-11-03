package ru.courses.oop.line;

import ru.courses.oop.point.Point;
import ru.courses.oop.polymorphisms.Polymorphism3;

public class Line implements Polymorphism3 {
  Point begin;
  Point end;

  public Line(Point begin, Point end) {
    this.begin = begin;
    this.end = end;
  }

  public Line(int x1, int y1, int x2, int y2) {
    this.begin = new Point(x1, y1);
    this.end = new Point(x2, y2);
  }

  @Override
  public String toString() {
    return "Линия от " + begin + " до " + end;
  }


  public double length() {
    return Math.sqrt(Math.pow((end.getX() - begin.getX()), 2) + Math.pow((end.getY() - begin.getY()), 2));
  }

}
