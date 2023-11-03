package ru.сourses.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Condition1 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.println("Результат: " + abs(a));
  }

  public static int abs(int x) {
    if (x >= 0)
      return x;
    else
      return -x;
  }
}