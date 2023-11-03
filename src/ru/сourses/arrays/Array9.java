package ru.сourses.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array9 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите длину массива arr1: ");
    String s1 = bufferedReader.readLine();
    int n1 = Integer.parseInt(s1);
    int[] array1 = new int[n1];
    System.out.println("Введите элементы массива arr1: ");
    for (int i = 0; i < n1; i++) {
      String s = bufferedReader.readLine();
      array1[i] = Integer.parseInt(s);
    }
    System.out.println("Введенный массив arr1: " + Arrays.toString(array1));

    System.out.print("Введите x: ");
    String s2 = bufferedReader.readLine();
    int x = Integer.parseInt(s2);

    System.out.println("Результат: " + Arrays.toString(findAll(array1, x)));
  }

  public static int[] findAll(int[] arr, int x) {
    int count = 0;
    int[] arr2 = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        arr2[i] = i;
        count++;
      } else
        arr2[i] = -1;
    }

    Arrays.sort(arr2);
    int[] arr3 = new int[count];

    for (int i = 0; i < arr2.length; i++) {
      if (arr2[i] >= 0) {
        System.arraycopy(arr2, i, arr3, 0, arr3.length);
        break;
      }
    }

    return arr3;
  }
}