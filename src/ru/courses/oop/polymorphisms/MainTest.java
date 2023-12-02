package ru.courses.oop.polymorphisms;

import ru.courses.oop.broken_line.BrokenLine;

import java.util.ArrayList;

public class MainTest {
  public static void main(String[] args) throws Exception {
    /*Polymorphism1 polymorphism1 = new Polymorphism1(1, 24, 5);
    System.out.println(polymorphism1);

    Polymorphism2 polymorphism2 = new Polymorphism2(new Point[]{new Point(1, 5), new Point(2, 8),
            new Point(5, 3), new Point(8, 9)});

    System.out.println(polymorphism2);
    System.out.println(polymorphism2.lenght1());

    Fraction fraction = new Fraction(3,5);
    System.out.println(fraction.intValue());
    System.out.println(fraction.longValue());
    System.out.println(fraction.floatValue());
    System.out.println(fraction.doubleValue());*/


   /* Point point1 = new Point(3, 4);
    Point point2 = new Point(3, 4);
    Point point3 = point2.clone();

    System.out.println("point1 == point2 - " + (point1 == point2));
    System.out.println("point1.equals(point2) - " + point1.equals(point2));
    System.out.println("----------");
    System.out.println("point2 == point3 - " + (point2 == point3));
    System.out.println("point2.equals(point3) - " + point2.equals(point3));

    Fraction fraction1 = new Fraction(3, 4);
    Fraction fraction2 = new Fraction(3, 4);
    Fraction fraction3 = fraction2.clone();


    System.out.println("== : " + (fraction1 == fraction2));
    System.out.println("equals : " + (fraction1.equals(fraction2)));
    System.out.println(fraction3);

    fraction1.num = 4;
    fraction2.num = 4;
    System.out.println("equals : " + (fraction1.equals(fraction2)));
    System.out.println(fraction3);*/

    /*Line line1 = new Line(new Point(3, 4), new Point(5, 0));
    Line line2 = new Line(new Point(3, 4), new Point(5, 0));
    //Line line3 = line2.clone();
    Line line3 = new Line(line2.start.clone(), line2.end.clone());

    System.out.println("== : " + (line1 == line2));
    System.out.println("equals : " + (line1.equals(line2)));
    System.out.println(line3);


    line2.start = new Point(5, 6);
    System.out.println(line2);
    System.out.println("equals : " + (line2.equals(line3)));
    System.out.println(line3);


   /* PolyLine polyLine1 = new PolyLine(new Point[]{new Point(1, 1), new Point(2, 2), new Point(3, 3)});
    PolyLine polyLine2 = new PolyLine(new Point[]{new Point(1, 1), new Point(2, 2), new Point(3, 3)});

    System.out.println(polyLine1.toString());
    System.out.println(polyLine2.toString());

    System.out.println("== : " + (polyLine1 == polyLine2));
    System.out.println("equals: " + (polyLine1.equals(polyLine2)));

    polyLine1.points[0] = new Point(2, 3);
    System.out.println(polyLine1.toString());

    System.out.println("== : " + (polyLine1 == polyLine2));
    System.out.println("equals: " + (polyLine1.equals(polyLine2)));*/


    Polymorphism2 polymorphism2 = new Polymorphism2(new Point[]{new Point(1, 5), new Point(2, 8),
            new Point(5, 3), new Point(8, 9)});
    BrokenLine brokenLine = new BrokenLine(new ru.courses.oop.point.Point[]{new ru.courses.oop.point.Point(1, 5), new ru.courses.oop.point.Point(2, 8), new ru.courses.oop.point.Point(5, 3), new ru.courses.oop.point.Point(8, 9),});

    ArrayList<Polymorphism3> arrayList = new ArrayList<>();

    arrayList.add(polymorphism2);
    arrayList.add(brokenLine);

    method(arrayList);

  }

  public static void method(ArrayList<Polymorphism3> polymorphism3s) {
    for (int i = 0; i < polymorphism3s.size(); i++) {
      System.out.println(polymorphism3s.get(i).lenght());
    }
  }


}
