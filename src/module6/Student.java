package module6;

import java.util.Arrays;

public class Student {
  private final String name;
  private int[] assessment = new int[0];

  public Student(String name) {
    this.name = name;
  }

  public Student(String name, int[] assessment) {
    this.name = name;
    for (int j : assessment) {
      if (j >= 2 && j <= 5) {
        this.assessment = assessment;
      } else {
        throw new IllegalArgumentException("Оценка принимает значения только 2 до 5");
      }
    }
  }

  public int[] getAssessment() {
    Student student = new Student(this.name, this.assessment);
    return student.assessment;
  }

  public void addAssessment(int[] assessment) {
    int[] array = Arrays.copyOf(this.assessment, this.assessment.length + assessment.length);

    for (int i = 0; i < assessment.length; i++) {
      if (assessment[i] >= 2 && assessment[i] <= 5) {
        array[this.assessment.length + i] = assessment[i];
      } else {
        throw new IllegalArgumentException("Оценка принимает значения только 2 до 5");
      }
    }

    this.assessment = Arrays.copyOf(array, this.assessment.length + assessment.length);
  }

  @Override
  public String toString() {
    return name + ": " + Arrays.toString(assessment);
  }

}
