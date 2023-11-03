package ru.courses.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Condition5 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число x: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.print("Введите число y: ");
    String s2 = bufferedReader.readLine();
    int b = Integer.parseInt(s2);

    System.out.print("Введите число y: ");
    String s3 = bufferedReader.readLine();
    int c = Integer.parseInt(s3);

    System.out.println("Результат: " + max3(a, b, c));
  }

  public static int max3(int x, int y, int z) {
    if (max2(x, y) >= z)
      return max2(x, y);
    else
      return z;
  }

  public static int max2(int x, int y) {
    if (x >= y)
      return x;
    else
      return y;
  }
}