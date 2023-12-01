package ru.courses.oop.employees;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {
  public String name;
  public Department department;

  @Override
  public String toString() {
    if (!name.equals(department.chief.name)) {
      return name + " работает в отделе " + department.name + ", начальник которого " + department.chief.name;
    } else {
      return name + " начальник отдела " + department.name;
    }
  }
}
