package module6;

import java.io.IOException;
import java.util.Arrays;

public class MainStudent {
  public static void main(String[] args) throws IOException {
    Student student1 = new Student("Artem");
    Student student2 = new Student("Anna", new int[]{5, 2, 5, 4, 3});
    System.out.println(student1);
    System.out.println(student2);

    student2.setAssessment(new int[]{2});
    System.out.println(student2);

  }
}
