package edu.innotech;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class StudentTests {

  @ParameterizedTest(name = "Добавление валидного набора оценок")
  @MethodSource("edu.innotech.GradeGenerator#validGrades")
  public void addGradesPositive(int x) {
    Student student = new Student("Artem");
    student.addGrade(x);
    System.out.println(student);
  }


  @ParameterizedTest(name = "Добавление невалидного набора оценок")
  @MethodSource("edu.innotech.GradeGenerator#noValidGrade")
  public void addGradesNegative(int x) {
    Student student = new Student("Artem");
    Assertions.assertThrows(IllegalArgumentException.class, () -> student.addGrade(x));
    System.out.println(student);
  }

  @Test
  @DisplayName("Проверяем инкапсуляцию положительных оценок через добавление")
  public void addGradeValid() {
    Student student = new Student("Artem");

    student.addGrade(2);
    student.addGrade(3);
    student.addGrade(4);
    student.addGrade(5);

    List list = List.copyOf(student.getGrades());

    student.getGrades().add(5);
    student.getGrades().add(4);
    student.getGrades().add(3);
    student.getGrades().add(2);

    Assertions.assertEquals(student.getGrades(), list);
  }

  @Test
  @DisplayName("Проверяем инкапсуляцию невалидных оценок через добавление")
  public void addGradeNoValid() {
    Student student = new Student("Artem");

    student.addGrade(2);
    student.addGrade(3);
    student.addGrade(4);
    student.addGrade(5);

    List list = List.copyOf(student.getGrades());

    student.getGrades().add(0);
    student.getGrades().add(1);
    student.getGrades().add(6);
    student.getGrades().add(7);

    Assertions.assertEquals(student.getGrades(), list);
  }


  @Test
  @DisplayName("Проверяем имя студента")
  public void checkName() {
    String name = "Artem";
    Student student = new Student(name);
    Assertions.assertEquals(student.getName(), name);
  }


  @Test
  @DisplayName("Проверяем смену имени студента")
  public void checkChangeName() {
    String noValidName = "Arte";
    Student student = new Student(noValidName);
    String validName = "Artem";
    student.setName(validName);
    Assertions.assertEquals(student.getName(), validName);
  }


  @Test
  @DisplayName("Проверяем отображаение данных по студенту")
  public void checkToString() {
    Student student = new Student("Artem");
    student.addGrade(5);
    student.addGrade(3);

    Assertions.assertEquals(student.toString(), "Student{name=Artem, marks=[5, 3]}");
  }

  @Test
  @DisplayName("Проверяем сравнение студентов")
  public void checkEquals() throws CloneNotSupportedException {
    String name = "Artem";

    Student student1 = new Student(name);
    for (int i = 2; i <= 5; i++) {
      student1.addGrade(i);
    }

    Student student2 = new Student(name);
    for (int i = 2; i <= 5; i++) {
      student2.addGrade(i);
    }

    Assertions.assertEquals(student1.equals(student2), true);
  }

}