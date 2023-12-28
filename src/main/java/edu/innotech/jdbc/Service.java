package edu.innotech.jdbc;


import java.sql.*;
import java.util.ArrayList;

public class Service {
  public static void main(String[] args) {
    firstTask();
  }

  public static void firstTask() {
    String url = "jdbc:h2:/Users/askvortsov/Downloads/Office/Office";
    int size = 0;
    try (Connection connection = DriverManager.getConnection(url)) {
      assert connection != null;
      Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

      ResultSet rs1 = statement.executeQuery("Select * from Employee join Department on Employee.DepartmentID=Department.ID where Employee.Name = \'Ann\'");
      System.out.println("Найдите ID сотрудника с именем Ann. Если такой сотрудник только один, то установите его департамент в HR.");

      System.out.println("Ищем сотрудника Ann:");
      System.out.println("-----------------------");
      while (rs1.next()) {
        size++;
        System.out.println(rs1.getInt("Employee.ID") + " " + rs1.getString("Employee.Name")
                + " " + rs1.getString("Department.Name"));
      }
      System.out.println("-----------------------");

      ResultSet resultSetDepartment = statement.executeQuery("select* from department where name = \'HR\'");

      int resultID = 0;
      while (resultSetDepartment.next()) {
        resultID = resultSetDepartment.getInt("ID");
      }


      if (size == 1) {
        statement.executeUpdate("UPDATE employee SET departmentID =" + resultID + " where name=\'Ann\'");
      }


      ResultSet rs3 = statement.executeQuery("Select * from Employee join Department on Employee.DepartmentID=Department.ID where Employee.Name = \'Ann\'");

      System.out.println("Меняем его департамент на HR:");
      System.out.println("-----------------------");
      while (rs3.next()) {
        System.out.println(rs3.getInt("Employee.ID") + " " + rs3.getString("Employee.Name")
                + " " + rs3.getString("Department.Name"));
      }
      System.out.println("-----------------------");


      ResultSet rs4 = statement.executeQuery("Select * from Employee");
      int count = 0;


      ArrayList<String> stringArrayList = new ArrayList<>();
      ArrayList<Integer> integers = new ArrayList<>();

      while (rs4.next()) {
        StringBuilder upName = new StringBuilder();

        char[] chars = rs4.getString("name").toCharArray();

        if (Character.isLowerCase(chars[0])) {
          count++;

          chars[0] = Character.toUpperCase(chars[0]);
          for (char aChar : chars) {
            upName.append(aChar);
          }

          stringArrayList.add(String.valueOf(upName));
          integers.add(rs4.getInt("ID"));
        }
      }


      for (int i = 0; i < stringArrayList.size(); i++) {
        statement.executeUpdate("UPDATE employee SET name=" + "\'" + stringArrayList.get(i) + "\'" + " where id =" + integers.get(i));
      }


      System.out.println("Количество исправленных имён: " + count);

      ResultSet rs5 = statement.executeQuery("Select * from Employee where departmentID in (select id from department where name = \'IT\') ");

      int count1 = 0;
      while (rs5.next()) {
        count1++;
      }

      System.out.println("Количество сотрудников в IT-отделе: " + count1);

    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }


}


