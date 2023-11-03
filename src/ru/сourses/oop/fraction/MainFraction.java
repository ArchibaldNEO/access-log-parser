package ru.сourses.oop.fraction;

import ru.сourses.oop.fraction.Fraction;

import java.io.IOException;

public class MainFraction {
  public static void main(String[] args) throws IOException {
    Fraction f1 = new Fraction(36, 10);
    Fraction f2 = new Fraction(49, 12);
    Fraction f3 = new Fraction(3, 1);
    Fraction f4 = new Fraction(3, 2);

    Fraction s1 = f1.sum(f2);
    Fraction s2 = s1.sum(f3);
    Fraction s3 = s2.sum(f4);

    System.out.println(s1);
    System.out.println(s2);
    System.out.println(s3);
  }
}
