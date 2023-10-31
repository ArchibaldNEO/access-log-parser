package module6;

import java.io.IOException;

public class MainEmployee {

  public static void main(String[] args) throws IOException {
    Employee employee1 = new Employee("Артем", "ВТБ", "Артем");
    Employee employee2 = new Employee("Анна", "ВТБ", "Артем");
    Employee employee3 = new Employee("Кирилл", "ВТБ", "Артем");
    Employee employee4 = new Employee("Доня", "ВТБ", "Артем");

    System.out.println(employee1);
    System.out.println(employee2);
    System.out.println(employee3);
    System.out.println(employee4);
  }
}
