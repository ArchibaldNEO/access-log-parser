package module4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array11 {
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

    System.out.print("Введите pos: ");
    String s3 = bufferedReader.readLine();
    int pos = Integer.parseInt(s3);

    System.out.println("Результат: " + Arrays.toString(add(array1, x, pos)));
  }

  public static int[] add(int[] arr, int x, int pos) {
    int[] arr2 = new int[arr.length + 1];

    for (int i = 0; i < pos; i++) {
      arr2[i] = arr[i];
    }

    arr2[pos] = x;

    for (int i = pos + 1; i <= arr.length; i++) {
      arr2[i] = arr[i - 1];
    }

    return arr2;
  }
}