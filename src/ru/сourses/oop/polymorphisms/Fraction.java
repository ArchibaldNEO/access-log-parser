package ru.сourses.oop.polymorphisms;

public class Fraction extends Number{
  int num, denuml;

  public Fraction(int num, int denuml) {
    this.num = num;
    this.denuml = denuml;
  }

  @Override
  public String toString() {
    return num + "/" + denuml;
  }

  @Override
  public int intValue() {
    return num/denuml;
  }

  @Override
  public long longValue() {
    return num/denuml;
  }

  @Override
  public float floatValue() {
    return (float) num /denuml;
  }

  @Override
  public double doubleValue() {
    return (double) num /denuml;
  }
}

