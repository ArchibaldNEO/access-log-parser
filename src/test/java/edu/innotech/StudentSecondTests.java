package edu.innotech;

import edu.innotech.mocks.StudentSecondRepositoryMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class StudentSecondTests {

  @ParameterizedTest(name = "Добавление валидного набора оценок")
  @MethodSource("edu.innotech.GradeGenerator#validGrades")
  public void testAddPositive(int x) {
    StudentSecond studentSecond = new StudentSecond("Artem");
    studentSecond.setRepo(new StudentSecondRepositoryMock());
    studentSecond.addGrade(x);
    List list = List.copyOf(studentSecond.getGrades());
    Assertions.assertEquals(studentSecond.getGrades(), list);
  }

  @ParameterizedTest(name = "Добавление невалидного набора оценок")
  @MethodSource("edu.innotech.GradeGenerator#noValidGrade")
  public void testAddNegative(int x) {
    StudentSecond studentSecond = new StudentSecond("Artem");
    studentSecond.setRepo(new StudentSecondRepositoryMock());
    Assertions.assertThrows(IllegalArgumentException.class, () -> studentSecond.addGrade(x));
  }

}