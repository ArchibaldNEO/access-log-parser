package ru.сourses.conditions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Condition6 {
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

    System.out.println("Результат: " + sum3(a, b, c));
  }

  public static boolean sum3(int x, int y, int z) {
    return (x + y == z) || (z + x == y) || (y + z == x);
  }
}