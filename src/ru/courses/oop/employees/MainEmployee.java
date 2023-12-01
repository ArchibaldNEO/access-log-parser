package ru.courses.oop.employees;

import java.io.IOException;

public class MainEmployee {

  public static void main(String[] args) throws IOException {
    Department it = new Department();
    it.name = "IT";

    Employee skvortsovAS = new Employee();
    skvortsovAS.name = "Скворцов АС";
    skvortsovAS.department = it;

    Employee makhlai = new Employee();
    makhlai.name = "Махлай АС";
    makhlai.department = it;

    Employee skvortsovKA = new Employee();
    skvortsovKA.name = "Скворцов КА";
    skvortsovKA.department = it;

    Employee donald = new Employee();
    donald.name = "Дональд";
    donald.department = it;

    it.chief = skvortsovAS;
    System.out.println(skvortsovAS);
    System.out.println(makhlai);
    System.out.println(skvortsovKA);
    System.out.println(donald);

  }
}
