package ru.courses.oop.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class stream1 {
  public static void main(String[] args) {
    /*ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, -5, -5, -1, 0, 6776, 8789));
    List<Integer> list = arrayList.stream().limit(3).filter(i -> i < 5).sorted().collect(Collectors.toList());
    System.out.println(list);
    System.out.println(arrayList.stream().sorted().collect(Collectors.toList()));*/

    List<String> lists = new ArrayList<>();
    lists.add("One");
    lists.add("Two");
    lists.add("Three");
    lists.add("Four");
    lists.add("Five");
    lists.add("Six");
    lists.add("Seven");
    lists.add("Eight");
    lists.add("Nine");
    lists.add("Ten");

    Stream<String> stringStream = lists.stream();

    System.out.println(getStringFromStream(stringStream));

  }

  public static String getStringFromStream(Stream stringStream) {
    return stringStream.collect(Collectors.joining(" ")).toString();
  }

}
