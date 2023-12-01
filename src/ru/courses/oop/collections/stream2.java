package ru.courses.oop.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class stream2 {
  public static void main(String[] args) {
    ArrayList<String> lists = new ArrayList<>();
    lists.add("One");
    lists.add("Two");
    lists.add("Three");
    lists.add("Four");
    lists.add("Five");


    printList(lists);
    System.out.println();
    printListLM(lists);

  }

  public static void printList(ArrayList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
  }

  public static void printListLM(ArrayList list) {
    //list.forEach(System.out::println);
    list.forEach(value -> System.out.println(value));
  }

}

