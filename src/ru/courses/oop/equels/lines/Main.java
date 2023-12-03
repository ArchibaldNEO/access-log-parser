package ru.courses.oop.equels.lines;

import ru.courses.oop.polymorphisms.Point;


public class Main {
  public static void main(String[] args) throws Exception {

    Line line1 = new Line(new Point(3, 4), new Point(5, 0));
    Line line2 = new Line(new Point(3, 4), new Point(5, 0));

    System.out.println("== : " + (line1 == line2));
    System.out.println("equals : " + (line1.equals(line2)));

    Line line3 = line2.clone();

    System.out.println(line3);

    System.out.println("== : " + (line2 == line3));
    System.out.println("equals : " + (line2.equals(line3)));


  }
}
