package ru.courses.oop.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class stream3 {
  public static void main(String[] args) throws Exception {
    Cat cat = new Cat("Vasya", 10, new ArrayList<>(Arrays.asList("Anton", "Oleg", "Igor")));
    setValueNULL(Cat.class, cat);
    System.out.println(cat);

  }

  private static void setValueNULL(Class<?> type, Object object) throws Exception {
    Field[] fields = type.getDeclaredFields();

    for (Field value : fields) {
      Field field = type.getDeclaredField(value.getName());
      boolean typeField = value.getType().isPrimitive();
      if (!typeField) {
        field.setAccessible(true);
        field.set(object, null);
      }
    }
  }
}

