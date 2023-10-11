package module2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IF10 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите число x: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.println("Результат: " + age(a));
  }

  public static String age(int x) {
    if ((x % 10 == 1) && (x / 11 == 0))
      return x + " год";
    else if (((x % 10 == 2) || (x % 10 == 3) || (x % 10 == 4)) && (x / 12 == 0) && (x / 13 == 0) && (x / 14 == 0)) {
      return x + " года";
    } else
      return x + " лет";
  }
}