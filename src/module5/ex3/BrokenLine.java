package module5.ex3;

import module5.ex1.Point;
import module5.ex2.Line;
import module7.Polymorphism3;

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
