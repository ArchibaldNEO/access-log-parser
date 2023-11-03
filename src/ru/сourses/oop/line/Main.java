package ru.сourses.oop.line;

import ru.сourses.oop.point.Point;

import java.io.IOException;

public class Main {
  public static void main(String[] args) throws IOException {
    Line line1 = new Line(new Point(1, 3), new Point(5, 8));
    Line line2 = new Line(new Point(10, 11), new Point(15, 19));
    Line line3 = new Line(line1.end, line2.begin);
    //System.out.println(line1);
    //System.out.println(line2);
    System.out.println(line3);

    /*System.out.println();
    System.out.println("Длина отрезка " + line1 + " - " + line1.length());
    System.out.println("Длина отрезка " + line2 + " - " + line2.length());
    System.out.println("Длина отрезка " + line3 + " - " + line3.length());
    System.out.println("Суммарная длина всех линий: " + (line1.length() + line2.length() + line3.length()));*/

    line3.begin.setX(6);
    line3.begin.setY(9);
    line3.end.setX(11);
    line3.end.setY(12);

    //System.out.println();
    //System.out.println(line1);
    //System.out.println(line2);
    System.out.println(line3);

    /*System.out.println("Длина отрезка " + line1 + " - " + line1.length());
    System.out.println("Длина отрезка " + line2 + " - " + line2.length());
    System.out.println("Длина отрезка " + line3 + " - " + line3.length());*/
    System.out.println("Суммарная длина всех линий: " + (line1.length() + line2.length() + line3.length()));


  }
}
