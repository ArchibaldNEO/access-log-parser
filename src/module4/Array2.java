package module4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array2 {
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
    System.out.println(Arrays.toString(array));

    System.out.print("x: ");
    String s3 = bufferedReader.readLine();
    int x = Integer.parseInt(s3);

    System.out.println("Результат: " + findFirst(array, x));
  }

  public static int findFirst(int[] arr, int x) {
    int first = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        first = i;
      }
    }
    return first;
  }
}