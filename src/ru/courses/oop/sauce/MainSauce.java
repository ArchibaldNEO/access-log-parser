package ru.courses.oop.sauce;


import static ru.courses.oop.sauce.Hot.*;

public class MainSauce {
  public static void main(String[] args) throws Exception {
    Sauce sauce1 = new Sauce("Чили", EXTRA_HOT);
    System.out.println(sauce1);

    Sauce sauce2 = new Sauce("Чесночный", HOT);
    System.out.println(sauce2);

    Sauce sauce3 = new Sauce("Сливочный", NOT_HOT);
    System.out.println(sauce3);
  }
}
