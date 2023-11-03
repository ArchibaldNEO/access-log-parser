package ru.сourses.cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cycle4 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s1 = bufferedReader.readLine();
    int x = Integer.parseInt(s1);

    System.out.print("y: ");
    String s2 = bufferedReader.readLine();
    int y = Integer.parseInt(s2);

    System.out.println("Результат: " + pow(x, y));
  }

  public static int pow(int x, int y) {
    int st = 1;
    for (int i = 0; i < y; i++) {
      st = x * st;
    }
    return st;
  }
}