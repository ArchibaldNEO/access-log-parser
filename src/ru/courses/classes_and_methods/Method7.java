package ru.courses.classes_and_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Method7 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите [a: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.print("Введите b]: ");
    String s2 = bufferedReader.readLine();
    int b = Integer.parseInt(s2);

    System.out.print("Введите num: ");
    String s3 = bufferedReader.readLine();
    int num = Integer.parseInt(s3);


    System.out.println("Результат: " + isInRange(a, b, num));
  }

  public static boolean isInRange(int a, int b, int num) {
    return (a <= num && num <= b) || (b <= num && num <= a);
  }
}