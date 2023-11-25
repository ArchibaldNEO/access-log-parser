package edu.innotech;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class Tests {

  //@Test
  //@DisplayName("Проверяем валидный набор оценок")
  @RepeatedTest(value = 4, name = "Добавляем валидные оценки")
  public void marksInRange(RepetitionInfo repetitionInfo) {
    //List<Integer> lst = List.of(2, 3, 4, 5);
    Student stud = new Student("vasia");
    int num = repetitionInfo.getCurrentRepetition() + 1;
    stud.addGrade(num);
   /* stud.addGrade(lst.get(0));
    stud.addGrade(lst.get(1));
    stud.addGrade(lst.get(2));
    stud.addGrade(lst.get(3));*/
    Assertions.assertEquals(stud.getGrades().get(0), num);
  }

  //@Test
  //@DisplayName("Проверяем невалидный набор оценок")
  @ParameterizedTest(name = "Добавление невалидных оценок")
  @MethodSource("edu.innotech.GradeGenerator#noValidGrade")
  public void marksNotInRange(int x) {
    //List<Integer> lst = List.of(0, 1, 6, 7);
    Student stud = new Student("vasia");
    Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(x));
    /*Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(0)));
    Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(1)));
    Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(2)));
    Assertions.assertThrows(IllegalArgumentException.class, () -> stud.addGrade(lst.get(3)));*/
  }




}