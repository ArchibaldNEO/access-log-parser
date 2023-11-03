package ru.сourses.oop.point;

public class Point {
  int X, Y;

  public Point(int x, int y) {
    this.X = x;
    this.Y = y;
  }

  @Override
  public String toString() {
    return "{" + X + ";" + Y +
            "}";
  }

  public int getX() {
    return X;
  }

  public void setX(int x) {
    X = x;
  }

  public void setY(int y) {
    Y = y;
  }

  public int getY() {
    return Y;
  }
}
