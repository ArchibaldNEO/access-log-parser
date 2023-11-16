package ru.courses.oop.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Exception4 {
  public static void main(String[] args) throws OperationAttemptException {
    System.out.println(divide("/Users/askvortsov/Docum2ents/Autotests_StepUP/AccessLogParser/src/ru/courses/oop/exceptions/file"));
  }

  public static int divide(String fileName) throws OperationAttemptException {
    File f = new File(fileName);
    Scanner sc = null;
    int n = 0;

    try {
      sc = new Scanner(f);
    } catch (FileNotFoundException e) {
      throw new OperationAttemptException("0");
    }

    try {
      n = sc.nextInt() / sc.nextInt();
    } catch (Exception e) {
      throw new OperationAttemptException("0");
    } finally {
      sc.close();
    }
    return n;
  }
}
