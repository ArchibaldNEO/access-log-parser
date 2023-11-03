package ru.сourses.classes_and_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Method6 {
  public static void main(String[] args) throws IOException {
    System.out.print("Введите символ: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();

    System.out.println("Результат: " + isUpperCase(s.charAt(0)));
  }

  public static boolean isUpperCase(char x) {
    return String.valueOf(x).equals(String.valueOf(x).toUpperCase());
  }
}