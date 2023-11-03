package ru.courses.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Condition2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число x: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.print("Введите число y: ");
    String s2 = bufferedReader.readLine();
    int b = Integer.parseInt(s2);

    System.out.println("Результат: " + safeDiv(a, b));
  }

  public static int safeDiv(int x, int y) {
    if (y == 0)
      return 0;
    else
      return x / y;
  }
}