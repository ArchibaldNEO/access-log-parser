package ru.courses.classes_and_methods;

import java.io.IOException;

public class Method10 {
  public static void main(String[] args) throws IOException {
    System.out.println("Результат: " + lastNumSum(lastNumSum(lastNumSum(lastNumSum(5, 11), 123), 14), 1));
  }

  public static int lastNumSum(int a, int b) {
    return (a % 10) + (b % 10);
  }
}