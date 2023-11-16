package ru.courses.oop.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex1 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> arrayList = new ArrayList<>();

    System.out.print("Введите размерность Листа (четное число): ");
    String s1 = bufferedReader.readLine();
    int n = Integer.parseInt(s1);


    if (n % 2 == 0) {
      for (int i = 1; i <= n; i++) {
        arrayList.add(i);
      }
      System.out.println("Оригинальный лист: " + arrayList);
      for (int i = 0; i < n - 1; i = i + 2) {
        int j = arrayList.get(i);
        int k = arrayList.get(i + 1);
        arrayList.set(i, k);
        arrayList.set(i + 1, j);
      }
      System.out.println("Отсортированный лист: " + arrayList);
    } else
      System.out.println("Размерность Листа должна быть четным числом!!!");
  }
}
