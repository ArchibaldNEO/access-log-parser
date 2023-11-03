package ru.courses.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array6 {
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
    System.out.println("Введенный массив " + Arrays.toString(array));

    reverse(array);
  }

  public static void reverse(int[] arr) {
    int temp;
    int n = arr.length;

    for (int i = 0; i < n / 2; i++) {
      temp = arr[n - i - 1];
      arr[n - i - 1] = arr[i];
      arr[i] = temp;
    }

    System.out.println("Перевернутый массив "+Arrays.toString(arr));
  }
}

