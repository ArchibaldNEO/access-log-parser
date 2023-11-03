package ru.courses.oop.students;

import java.io.IOException;
import java.util.Arrays;

public class MainStudent {
  public static void main(String[] args) throws IOException {
    Student student1 = new Student("Artem");
    Student student2 = new Student("Anna", new int[]{5, 2, 5, 5, 3});
    System.out.println(student1);
    System.out.println(student2);


    student2.addAssessments(new int[]{5,4,3});
    System.out.println(student2);

    student1.addAssessments(new int[]{3,4,5});
    System.out.println(student1);
    student1.addAssessments(new int[]{5,3,4});
    System.out.println(student1);

    System.out.println();
    System.out.println(Arrays.toString(student2.getAssessment()));



  }
}
