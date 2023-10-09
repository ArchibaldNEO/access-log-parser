package module4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Array3 {
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

    System.out.println("Результат: " + maxAbs(array));
  }

  public static int maxAbs(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int j : arr) {
      int abs = Math.abs(j);
      if (abs >= max)
        max = abs;
    }
    return max;
  }

}