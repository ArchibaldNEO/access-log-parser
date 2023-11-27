package edu.innotech.mocks;

public class StudentSecondRepositoryMock implements StudentRepository {
  public boolean checkGrade(int grade) {
    return !(grade < 2 || grade > 5);
  }
}
