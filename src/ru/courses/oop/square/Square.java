package ru.courses.oop.square;

public class Square {
  private int x;
  private int y;
  private int len;

  public Square(int x, int y, int len) {
    setX(x);
    setY(y);
    setLen(len);
  }

  @Override
  public String toString() {
    return "Квадрат в точке " + "{" + x + ";" + y + "}" +
            " со стороной " + len + ", где " + len + " – длина стороны, а " +
            "{" + x + ";" + y + "}" + " – результат приведения к строке верхнего левого угла ";
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void setLen(int len) {
    if (len > 0)
      this.len = len;
    else
      throw new IllegalArgumentException("Длина стороны обязана быть всегда положительной");
  }
}
