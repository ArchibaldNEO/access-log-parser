package module4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array8 {
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


    System.out.print("Введите длину массива arr2: ");
    String s2 = bufferedReader.readLine();
    int n2 = Integer.parseInt(s2);
    int[] array2 = new int[n2];
    System.out.println("Введите элементы массива arr2: ");
    for (int i = 0; i < n2; i++) {
      String s = bufferedReader.readLine();
      array2[i] = Integer.parseInt(s);
    }
    System.out.println("Введенный массив arr2: " + Arrays.toString(array2));

    System.out.println("Результат: " + Arrays.toString(concat(array1, array2)));
  }

  public static int[] concat(int[] arr1, int[] arr2) {
    int[] arr3 = new int[arr1.length + arr2.length];

    for (int i = 0; i < arr1.length; i++) {
      arr3[i] = arr1[i];
    }

    for (int i = 0; i < arr2.length; i++) {
      arr3[i + arr1.length] = arr2[i];
    }
    return arr3;
  }
}