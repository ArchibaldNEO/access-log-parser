package ru.courses.oop.collections;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class ex2 {
  public static void main(String[] args) throws IOException {
    ArrayList<Integer> intList = new ArrayList<>();
    intList.add(1);
    intList.add(441);
    intList.add(445);
    intList.add(6567);
    intList.add(77);
    intList.add(6661);

    bubbleSort(intList);
    System.out.println(intList);


    int[] intArray = {1, 441,445,6567,77,6661};

    bubbleSort(intArray);
    System.out.println(Arrays.toString(intArray));

  }

  public static void bubbleSort(ArrayList<Integer> intList) {
    for (int i = 0; i < intList.size() - 1; i++) {
      for (int j = 0; j < intList.size() - i - 1; j++) {
        if (intList.get(j) > intList.get(j + 1)) {
          int temp = intList.get(j);
          intList.set(j, intList.get(j + 1));
          intList.set(j + 1, temp);
        }
      }
    }
  }

  public static void bubbleSort(int[] intArray) {
    for (int out = intArray.length - 1; out >= 1; out--) {
      for (int in = 0; in < out; in++) {
        if (intArray[in] > intArray[in + 1]) {
          int dummy = intArray[in];
          intArray[in] = intArray[in + 1];
          intArray[in + 1] = dummy;
        }
      }
    }
  }
}
