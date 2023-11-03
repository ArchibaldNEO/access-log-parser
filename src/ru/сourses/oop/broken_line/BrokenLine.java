package ru.сourses.oop.broken_line;

import ru.сourses.oop.point.Point;
import ru.сourses.oop.line.Line;
import ru.сourses.oop.polymorphisms.Polymorphism3;

import java.util.Arrays;

public class BrokenLine implements Polymorphism3 {
  Point[] array;

  public BrokenLine(Point[] array) {
    this.array = array;
  }

  public double lenght() {
    double lenght = 0;
    for (int i = 0; i < array.length - 1; i++) {
      Line line = new Line(array[i], array[i + 1]);
      lenght = lenght + line.length();
    }
    return lenght;
  }

  public Line[] arrayLine() {
    Line[] lines = new Line[array.length - 1];
    for (int i = 0; i < array.length - 1; i++) {
      lines[i] = new Line(array[i], array[i + 1]);

    }
    return lines;
  }

  @Override
  public String toString() {
    return "Линия " + Arrays.toString(array);
  }
}
