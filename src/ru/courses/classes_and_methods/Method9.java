package ru.courses.classes_and_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Method9 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите a: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.print("Введите b: ");
    String s2 = bufferedReader.readLine();
    int b = Integer.parseInt(s2);

    System.out.print("Введите с: ");
    String s3 = bufferedReader.readLine();
    int c = Integer.parseInt(s3);

    System.out.println("Результат: " + isEqual(a, b, c));
  }

  public static boolean isEqual(int a, int b, int c) {
    return (a == b && b == c);
  }
}