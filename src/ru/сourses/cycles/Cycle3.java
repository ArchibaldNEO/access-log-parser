package ru.сourses.cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cycle3 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s = bufferedReader.readLine();
    int x = Integer.parseInt(s);

    System.out.println("Результат: " + chet(x));
  }

  public static String chet(int x) {
    String s = "";
    for (int i = 0; i <= x; i = i + 2) {
      s = s + i + " ";

    }
    return s;
  }
}