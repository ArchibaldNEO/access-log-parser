package ru.courses.oop.collections;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ex3 {
  public static void main(String[] args) throws IOException {
    ArrayList<Integer> intList = new ArrayList<>();
    intList.add(1);
    intList.add(2);
    intList.add(3);
    intList.add(4);
    intList.add(5);
    intList.add(6);

    reverse(intList);
    System.out.println(intList);


    int[] intArray = {1, 2, 3, 4, 5, 6};

    reverse(intArray);
    System.out.println(Arrays.toString(intArray));

  }

  public static void reverse(ArrayList<Integer> intList) {
    int n = intList.size() - 1;
    for (int i = 0; i < intList.size() / 2; i++) {
      int temp = intList.get(i);
      intList.set(i, intList.get(n - i));
      intList.set(n - i, temp);
    }

  }

  public static void reverse(int[] intArray) {
    int n = intArray.length - 1;
    for (int i = 0; i < intArray.length / 2; i++) {
      int temp = intArray[i];
      intArray[i] = intArray[n - i];
      intArray[n - i] = temp;
    }
  }
}
