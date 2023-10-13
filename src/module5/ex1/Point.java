package module5.ex1;

public class Point {
  int X, Y;

  public Point(int x, int y) {
    this.X = x;
    this.Y = y;
  }

  @Override
  public String toString() {
    return "{" + X + ";" + Y +
            "}";
  }

}
