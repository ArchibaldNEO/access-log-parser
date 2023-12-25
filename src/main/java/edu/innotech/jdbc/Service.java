package edu.innotech.jdbc;


import java.sql.*;

public class Service {
  public static void main(String[] args) {
    createDB();
  }

  public static void createDB() {
    String url = "jdbc:h2:/Users/askvortsov/Downloads/Office/Office";
    //String url1 = "jdbc:h2://localhost:5432//Office";
    try (Connection connection = DriverManager.getConnection(url)) {
      if (connection != null) {
        System.out.println("Good");
      } else {
        System.out.println("Fail");
      }

      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("select* from Employee");
      //System.out.println(resultSet);
      while (resultSet.next()) {
        System.out.println(resultSet.getInt("DepartmentID"));
      }
    } catch (SQLException ex) {
      System.out.println(ex);
    }
  }

}


