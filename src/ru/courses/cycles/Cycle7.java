package ru.courses.cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cycle7 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s1 = bufferedReader.readLine();
    int x = Integer.parseInt(s1);

    square(x);
  }

  public static void square(int x) {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < x; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}