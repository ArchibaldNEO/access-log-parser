package ru.courses.classes_and_methods;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Method3 {
  public static void main(String[] args) throws IOException {
    System.out.print("Введите символ: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();
    char c = s.charAt(0);

    System.out.println("Результат" + ": " + Character.getNumericValue(charToNum(c)));
  }

  public static int charToNum(char x) {
    return x;
  }
}