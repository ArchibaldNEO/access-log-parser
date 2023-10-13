package module5.ex3;

import module5.ex1.Point;

import java.io.IOException;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    double d = 0;
    BrokenLine brokenLine = new BrokenLine(new Point[]{new Point(1, 5), new Point(2, 8), new Point(5, 3), new Point(8, 9),});

    System.out.println("Ломанная: " + brokenLine);
    System.out.println("Длина ломанной: " + brokenLine.lenght());
    System.out.println("Массив линий: " + Arrays.toString(brokenLine.arrayLine()));


    for (int i = 0; i < brokenLine.arrayLine().length; i++) {
      d = d + brokenLine.arrayLine()[i].length();
    }

    System.out.println("Длина массива линий: " + d);
    System.out.println("Сравнение длины: " + (d == brokenLine.lenght()));

    System.out.println();
    brokenLine.array[1].setX(12);


    System.out.println("Ломанная: " + brokenLine);
    System.out.println("Массив линий: " + Arrays.toString(brokenLine.arrayLine()));


  }
}
