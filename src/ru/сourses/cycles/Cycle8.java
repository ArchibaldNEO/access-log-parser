package ru.сourses.cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cycle8 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s1 = bufferedReader.readLine();
    int x = Integer.parseInt(s1);

    leftTriangle(x);
  }

  public static void leftTriangle(int x) {
    for (int i = 0; i < x; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
}