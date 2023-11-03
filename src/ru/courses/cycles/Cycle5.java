package ru.courses.cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cycle5 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s1 = bufferedReader.readLine();
    int x = Integer.parseInt(s1);

    System.out.println("Результат: " + numLen(x));
  }

  public static int numLen(long x) {
    int count = 0;
    if (x != 0) {
      while (x != 0) {
        x = x / 10;
        count++;
      }
      return count;
    } else
      return 1;
  }
}