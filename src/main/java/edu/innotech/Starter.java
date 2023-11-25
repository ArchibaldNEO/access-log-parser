package edu.innotech;

public class Starter {
  public static void main(String[] args) {
    Student student = new Student("Artem");
    student.addGrade(5);
    student.addGrade(2);
    student.addGrade(4);
    student.addGrade(3);
    System.out.println(student);

    student.getGrades().add(7);
    System.out.println(student);

    student.getGrades().set(0,9);
    System.out.println(student);

  }
}
