package ru.courses.oop.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class stream3 {
  public static void main(String[] args) throws NoSuchFieldException {
    Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
    cat = null;
    System.gc();
  }

}

