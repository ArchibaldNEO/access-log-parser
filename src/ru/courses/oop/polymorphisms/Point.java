package ru.courses.oop.polymorphisms;

import java.util.Objects;


public class Point implements Cloneable {
  int x, y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }


  public int getX() {
    return x;
  }

  public void setX(int x) {
    x = x;
  }

  public void setY(int y) {
    y = y;
  }

  public int getY() {
    return y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Point point = (Point) o;
    return x == point.x && y == point.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  public Point clone() throws CloneNotSupportedException {
    return (Point) super.clone();
  }

  @Override
  public String toString() {
    return "Point{" +
            "x=" + x +
            ", y=" + y +
            '}';
  }
}
