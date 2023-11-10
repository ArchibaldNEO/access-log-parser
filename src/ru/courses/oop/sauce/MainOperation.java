package ru.courses.oop.sauce;

public class MainOperation {
  public static void main(String[] args) {
    System.out.println(op(1, 2, 1));
    Operation op1 = Operation.ADDITION;
    Operation op2 = Operation.SUBTRACTION;
    Operation op3 = Operation.MYLTIPLICATION;
    Operation op4 = Operation.DIVISION;
    System.out.println(op1.action(1, 2));
    System.out.println(op2.action(1, 2));
    System.out.println(op3.action(1, 2));
    System.out.println(op4.action(1, 2));


  }

  static int op(int x, int y, int op) {
    switch (op) {
      case 1:
        return x + y;
      case 2:
        return x - y;
      case 3:
        return x * y;
      case 4:
        return x / y;
    }
    return 0;
  }

  enum Operation {
    ADDITION {
      public int action(int x, int y) {
        return x + y;
      }
    }, SUBTRACTION {
      public int action(int x, int y) {
        return x - y;
      }
    },
    MYLTIPLICATION {
      public int action(int x, int y) {
        return x * y;
      }
    }, DIVISION {
      public int action(int x, int y) {
        return x / y;
      }
    };

    private int x,y;

    public abstract int action(int x, int y);
  }
}
