package ru.courses.oop.fraction;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DifficultFraction {
  private double doublePart;
  private int numerator;
  private int denominator;

  public DifficultFraction(int numerator, int denominator) {
    this.doublePart = (double) numerator / denominator;
  }

  public DifficultFraction(double doublePart) {
    this.doublePart = doublePart;
  }


}
