package ru.courses.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Condition8 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число x: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.println("Результат: " + is35(a));
  }

  public static boolean is35(int x) {
    if ((x % 3 == 0) && (x % 5 == 0))
      return false;
    else
      return (x % 3 == 0) || (x % 5 == 0);
  }
}