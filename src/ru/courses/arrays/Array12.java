package ru.courses.arrays;

import java.io.IOException;
import java.util.Arrays;

public class Array12 {
  public static void main(String[] args) throws IOException {
    /*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите длину массива arr: ");
    String s1 = bufferedReader.readLine();
    int n1 = Integer.parseInt(s1);
    int[] array1 = new int[n1];
    System.out.println("Введите элементы массива arr: ");
    for (int i = 0; i < n1; i++) {
      String s = bufferedReader.readLine();
      array1[i] = Integer.parseInt(s);
    }
    System.out.println("Введенный массив arr: " + Arrays.toString(array1));


    System.out.print("Введите длину массива ins: ");
    String s = bufferedReader.readLine();
    int n = Integer.parseInt(s);
    int[] array = new int[n];
    System.out.println("Введите элементы массива ins: ");
    for (int i = 0; i < n; i++) {
      String s12 = bufferedReader.readLine();
      array[i] = Integer.parseInt(s12);
    }
    System.out.println("Введенный массив ins: " + Arrays.toString(array));

    System.out.print("Введите pos: ");
    String s3 = bufferedReader.readLine();
    int pos = Integer.parseInt(s3);*/

    int[] arr = {1, 2, 3, 4, 5};
    int[] ins = {7, 8, 9};

    System.out.println("Результат: " + Arrays.toString(add(arr, ins, 3)));
  }

  public static int[] add(int[] arr, int[] ins, int pos) {

    int[] arr_1 = Arrays.copyOfRange(arr, 0, pos);
    int[] arr_2 = Arrays.copyOfRange(arr, pos, arr.length);

    int[] result = Arrays.copyOf(arr_1, arr_1.length + ins.length + arr_2.length);
    System.arraycopy(ins, 0, result, arr_1.length, ins.length);
    System.arraycopy(arr_2, 0, result, arr_1.length + ins.length, arr_2.length);


    return result;
  }
}