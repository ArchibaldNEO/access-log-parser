package edu.innotech.jdbc;


import java.sql.*;

public class Service {
  public static void main(String[] args) {
    //createDBstatement();
    //createDBprepareStatement();
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

    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }


}


