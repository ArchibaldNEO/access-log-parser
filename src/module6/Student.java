package module6;

import java.util.Arrays;

public class Student {
  private final String name;
  private int[] assessment = new int[0];

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

  public void setAssessment(int[] assessment) {
    int n = assessment.length;
    int[] array = Arrays.copyOf(this.assessment, this.assessment.length + n);
    for (int i = 0; i < n; i++) {
      if (assessment[i] >= 2 && assessment[i] <= 5) {
        array[this.assessment.length + i] = assessment[i];
      } else {
        throw new IllegalArgumentException("Оценка принимает значения только 2 до 5");
      }
    }
    //System.arraycopy(assessment, 0, array, this.assessment.length + 0, n);
    this.assessment = Arrays.copyOf(array, this.assessment.length + n);
  }

  public void setAssessment(int n) {
    if (n >= 2 && n <= 5) {
      System.out.println(this.assessment.length);
      int[] array = Arrays.copyOf(this.assessment, assessment.length + 1);
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
