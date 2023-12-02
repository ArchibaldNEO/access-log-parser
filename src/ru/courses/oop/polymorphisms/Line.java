package ru.courses.oop.polymorphisms;

import java.util.Objects;

public class Line implements Cloneable, Direct {
  Point start, end;

  public Line(Point start, Point end) {
    this.start = start;
    this.end = end;
  }

  public Line(int x1, int y1, int x2, int y2) {
    this.start = new Point(x1, y1);
    this.end = new Point(x2, y2);
  }

  public double length() {
    return Math.sqrt(Math.pow((end.getX() - start.getX()), 2) + Math.pow((end.getY() - start.getY()), 2));
  }


  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Line line = (Line) o;
    return Objects.equals(start, line.start) && Objects.equals(end, line.end);
  }

  @Override
  public int hashCode() {
    return Objects.hash(start, end);
  }

  @Override
  public Line clone() throws CloneNotSupportedException {
    //Line line1 = (Line) super.clone();
    return new Line((Point) super.clone(), (Point) super.clone());

  }

  @Override
  public String toString() {
    return "Line{" +
            "start=" + start +
            ", end=" + end +
            '}';
  }
}
