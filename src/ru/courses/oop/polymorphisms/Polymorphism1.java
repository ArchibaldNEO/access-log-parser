package ru.courses.oop.polymorphisms;

import ru.courses.oop.point.Point;

public class Polymorphism1 extends Point {
  private int Z;

  public Polymorphism1(int x, int y, int z) {
    super(x, y);
    this.Z = z;
  }

  public int getZ() {
    return Z;
  }

  @Override
  public String toString() {
    return "{" + getX() + ";" + getY() + ";" + Z + "}";
  }

  public void setZ(int z) {
    Z = z;
  }
}
