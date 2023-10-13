package module5.ex2;

import module5.ex1.Point;

public class Line {
  Point begin;
  Point end;

  public Line(Point begin, Point end) {
    this.begin = begin;
    this.end = end;
  }

  @Override
  public String toString() {
    return "Линия от " + begin + " до " + end;
  }

  public double length() {
    return Math.sqrt(Math.pow((end.getX() - begin.getX()), 2) + Math.pow((end.getY() - begin.getY()), 2));
  }


}
