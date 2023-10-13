package module5.ex1;

import java.util.Objects;

public class Point {
  int X, Y;

  public Point(int x, int y) {
    this.X = x;
    this.Y = y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(X, Y);
  }

  @Override
  public String toString() {
    return "{" + X + ";" + Y +
            "}";
  }

}
