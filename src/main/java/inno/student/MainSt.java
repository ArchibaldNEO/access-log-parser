package main.java.inno.student;

public class MainSt {
  public static void main(String[] args) {
    Student student = new Student("Arte");
    student.setName("Artem");
    System.out.println(student.getName());

    student.addGrade(2);
    student.addGrade(3);
    student.addGrade(4);
    student.addGrade(5);

   System.out.println(student.getGrades());
    //student.addGrade(1);
    //student.addGrade(6);
    System.out.println(student.getGrades().set(0,1));
    System.out.println(student.getGrades().set(2,9));
    student.addGrade(7);

    System.out.println(student);
  }
}
