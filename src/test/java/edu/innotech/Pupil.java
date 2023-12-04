package edu.innotech;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pupil {
  Integer id;
  String name;
  List<Integer> marks = new ArrayList<>();

  @Override
  public String toString() {
    return "Students{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", marks=" + marks +
            '}';
  }
}
