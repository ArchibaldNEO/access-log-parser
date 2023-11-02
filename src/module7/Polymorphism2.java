package module7;

import module5.ex1.Point;
import module5.ex2.Line;
import module5.ex3.BrokenLine;

public class Polymorphism2 extends BrokenLine {
  public Polymorphism2(Point[] array) {
    super(array);
  }

  public double lenght(BrokenLine[] brokenLines) {
    double lenght = 0;
    for (int i = 0; i < brokenLines.length - 1; i++) {
      lenght = lenght + brokenLines[i].lenght();
    }
    return lenght;
  }
}
