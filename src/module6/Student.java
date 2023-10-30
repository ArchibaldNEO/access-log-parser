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
    setAssessment(assessment);
  }

  public int[] getAssessment() {
    return assessment;
  }

  public void setAssessment(int[] assessment) {
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
