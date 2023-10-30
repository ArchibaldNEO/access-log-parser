package module6;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
  private final String name;
  private int[] assessment;

  public Student(String name, int[] assessment) {
    this.name = name;
    for (int i : assessment) {
      if (i >= 2 && i <= 5)
        this.assessment = assessment;
      else
        throw new IllegalArgumentException("Оценка принимает значения только 2 до 5");
    }
  }

  public Student(String name) {
    this.name = name;
  }

  public int[] getAssessment() {
    return assessment;
  }

  public void setAssessment(int n) {
    if (n >= 2 && n <= 5) {
      int[] array = Arrays.copyOf(assessment, assessment.length + 1);
      array[assessment.length] = n;
      this.assessment = array;
    } else {
      throw new IllegalArgumentException("Оценка принимает значения только 2 до 5");
    }
  }


  @Override
  public String toString() {
    return name + ": " + Arrays.toString(assessment);
  }

}
