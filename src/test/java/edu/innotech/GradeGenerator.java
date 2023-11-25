package edu.innotech;

import java.util.List;

public class GradeGenerator {

  public static List<Integer> noValidGrade() {
    return List.of(0, 1, 6, 9);
  }

  public static List<Integer> validGrades() {
    return List.of(2, 3, 4, 5);
  }
}
