package ru.сourses.oop.point;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Point point1 = new Point(1, 3);
    Point point2 = new Point(1, 3);
    Point point3 = new Point(5, 8);

    System.out.println(point1);
    System.out.println(point2);
    System.out.println(point3);

    boolean eq1 = point1 == point2;
    boolean eq2 = point1 == point3;

    System.out.println("Результат сравнения " + point1 + " и " + point2 + " - " + eq1);
    System.out.println("Результат сравнения " + point1 + " и " + point3 + " - " + eq2);


  }
}
