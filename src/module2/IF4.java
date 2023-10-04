package module2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IF4 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число x: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.print("Введите число y: ");
    String s2 = bufferedReader.readLine();
    int b = Integer.parseInt(s2);

    System.out.println("Результат: " + makeDecision(a, b));
  }

  public static String makeDecision(int x, int y) {
    if (x > y)
      return x + " > " + y;
    else if (x < y)
      return x + " < " + y;
    else
      return x + " == " + y;
  }
}