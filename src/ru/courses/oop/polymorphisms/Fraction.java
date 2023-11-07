package ru.courses.oop.polymorphisms;

import java.util.Objects;

public class Fraction extends Number implements Cloneable {
  int num, denuml;

  public Fraction(int num, int denuml) {
    this.num = num;
    this.denuml = denuml;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Fraction fraction = (Fraction) o;
    return num == fraction.num && denuml == fraction.denuml;
  }

  @Override
  public int hashCode() {
    return Objects.hash(num, denuml);
  }

  @Override
  public Fraction clone() {
    try {
      // TODO: copy mutable state here, so the clone can't change the internals of the original
      return (Fraction) super.clone();
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }

  @Override
  public String toString() {
    return num + "/" + denuml;
  }

  @Override
  public int intValue() {
    return num / denuml;
  }

  @Override
  public long longValue() {
    return num / denuml;
  }

  @Override
  public float floatValue() {
    return (float) num / denuml;
  }

  @Override
  public double doubleValue() {
    return (double) num / denuml;
  }

}

