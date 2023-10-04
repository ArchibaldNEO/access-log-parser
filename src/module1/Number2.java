package module1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number2 {
  public static void main(String[] args) throws IOException {
    System.out.print("Введите число: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();
    int d = Integer.parseInt(s);

    System.out.println("Сумма последних 2х цифр числа " + d + " = " + sumLastNums(d));
  }

  public static int sumLastNums(int x) {
    int sum = 0;
    for (int i = 0; i < 2; i++) {
      sum = sum + x % 10;
      x = x / 10;
    }
    return sum;
  }
}