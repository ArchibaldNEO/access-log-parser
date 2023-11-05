package ru.courses.oop.packages;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainPow {
  public static void main(String[] args) throws IOException {
    System.out.print("Введите X: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s1 = bufferedReader.readLine();

    System.out.print("Введите Y: ");
    String s2 = bufferedReader.readLine();


    System.out.println("Результат возведения X в степень Y: " + new Pow().pow(s1, s2));
  }

}

