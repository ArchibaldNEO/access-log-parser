package module6;

import java.util.Arrays;

public class Student {
  private final String name;
  private int[] assessment;

  public Student(String name, int[] assessment) {
    this.name = name;
    setAssessment(assessment);
  }

  public Student(String name) {
    this.name = name;
  }

  public int[] getAssessment() {
    return assessment;
  }

  public void setAssessment(int[] assessment) {
    for (int j : assessment) {
      if (j >= 2 && j <= 5)
        this.assessment = assessment;
      else
        throw new IllegalArgumentException("Оценка принимает значения только 2 до 5");
    }
  }

  @Override
  public String toString() {
    return name + ": " + Arrays.toString(assessment);
  }

}
