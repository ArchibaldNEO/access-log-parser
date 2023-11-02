package module7;

import module5.ex1.Point;
import module5.ex2.Line;

public class Polymorphism2 extends Line {

  public Polymorphism2(Point begin, Point end) {
    super(begin, end);
  }

  public Polymorphism2(int x1, int y1, int x2, int y2) {
    super(x1, y1, x2, y2);
  }

  public double length(Line[] line) {
    double l = 0;
    for (Line value : line) {
      l = l + value.length();
    }
    return l;
  }
}
