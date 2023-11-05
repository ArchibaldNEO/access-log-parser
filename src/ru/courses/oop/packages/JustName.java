package ru.courses.oop.packages;

import ru.courses.oop.point.Point;


import java.io.IOException;

public class JustName {
  public static void main(String[] args) throws IOException {
    Point point = new Point(1, 2);
    ru.courses.oop.polymorphisms.Point point1 = new ru.courses.oop.polymorphisms.Point(2, 4);

    System.out.println(point);
    System.out.println(point1);
  }
}
