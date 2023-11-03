package ru.сourses.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array5 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите длину массива: ");
    String s1 = bufferedReader.readLine();
    int n = Integer.parseInt(s1);
    int[] array = new int[n];
    System.out.println("Введите элементы массива:");
    for (int i = 0; i < n; i++) {
      String s2 = bufferedReader.readLine();
      array[i] = Integer.parseInt(s2);
    }
    System.out.println("Введенный массив" + Arrays.toString(array));

    System.out.println("Результат: " + palindrom(array));
  }

  public static boolean palindrom(int[] arr) {
    int[] arr1 = new int[arr.length];
    for (int i = arr.length - 1; i >= 0; i--) {
      arr1[arr.length - i - 1] = arr[i];
    }
    System.out.println("Перевернутый массив" + Arrays.toString(arr1));
    return Arrays.equals(arr, arr1);
  }

}