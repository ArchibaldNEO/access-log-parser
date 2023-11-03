package ru.courses.cycles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cycle1 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s = bufferedReader.readLine();
    int x = Integer.parseInt(s);

    System.out.println("Результат: " + listNums(x));
  }

  public static String listNums(int x) {
    String s = "";
    for (int i = 0; i <= x; i++) {
      s = s + i + " ";
    }
    return s;
  }
}