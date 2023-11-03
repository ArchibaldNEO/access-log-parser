package ru.courses.oop.square;

import java.io.IOException;

public class MainSquare {
  public static void main(String[] args) throws IOException {
    Square square = new Square(1, 5, 10);
    System.out.println(square);

    square.setX(1);
    square.setY(1);
    square.setLen(1);
    System.out.println(square);

  }
}
