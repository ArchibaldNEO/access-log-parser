package ru.courses.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Condition9 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число x: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.print("Введите число y: ");
    String s2 = bufferedReader.readLine();
    int b = Integer.parseInt(s2);

    System.out.println("Результат: " + magic6(a, b));
  }

  public static boolean magic6(int x, int y) {
    return (x == 6) || (y == 6) || (x + y) == 6 || (x - y) == 6 || (y - x == 6);
  }
}