package ru.courses.oop.polymorphisms;

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
    System.out.println("point2.equals(point3) - " + point2.equals(point3));*/

    Fraction fraction1 = new Fraction(3, 4);
    Fraction fraction2 = new Fraction(3, 4);
    Fraction fraction3 = fraction2.clone();


    System.out.println("== : " + (fraction1 == fraction2));
    System.out.println("equals : " + (fraction1.equals(fraction2)));
    System.out.println(fraction3);

    fraction1.num = 4;
    fraction2.num = 4;
    System.out.println("equals : " + (fraction1.equals(fraction2)));
    System.out.println(fraction3);

  }
}
