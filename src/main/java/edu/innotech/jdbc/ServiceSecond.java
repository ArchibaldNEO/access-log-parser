package edu.innotech.jdbc;


import java.sql.*;
import java.util.ArrayList;

public class ServiceSecond {
  public static void main(String[] args) {
    secondTask();
  }

  public static void secondTask() {
    String url = "jdbc:h2:/Users/askvortsov/Downloads/Office/Office";
    try (Connection connection = DriverManager.getConnection(url)) {
      assert connection != null;
      Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

      int sizeBefore = 0;
      int sizeAfter = 0;

      ResultSet rs1 = statement.executeQuery("Select * from Employee join Department on Employee.DepartmentID=Department.ID");

      System.out.println("-----------------------");
      while (rs1.next()) {
        sizeBefore++;
        System.out.println(rs1.getInt("Employee.ID") + " " + rs1.getString("Employee.Name")
                + " " + rs1.getString("Department.Name"));
      }
      System.out.println("-----------------------");

      statement.executeUpdate("DELETE FROM department WHERE ID=1");

      ResultSet rs2 = statement.executeQuery("Select * from Employee join Department on Employee.DepartmentID=Department.ID");

      System.out.println("-----------------------");
      while (rs2.next()) {
        sizeAfter++;
        System.out.println(rs2.getInt("Employee.ID") + " " + rs2.getString("Employee.Name")
                + " " + rs2.getString("Department.Name"));
      }
      System.out.println("-----------------------");

      System.out.println("Размер таблицы сотрудников до удаление отдела: " + sizeBefore);
      System.out.println("Размер таблицы сотрудников после удаление отдела: " + sizeAfter);


    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }


}


