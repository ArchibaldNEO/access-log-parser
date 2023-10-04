package module2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IF12 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s = bufferedReader.readLine();

    printDays(s);
  }

  public static void printDays(String x) {
    switch (x) {
      case "Понедельник":
        System.out.println("Понедельник");
      case "Вторник":
        System.out.println("Вторник");
      case "Среда":
        System.out.println("Среда");
      case "Четверг":
        System.out.println("Четверг");
      case "Пятница":
        System.out.println("Пятница");
      case "Суббота":
        System.out.println("Суббота");
      case "Воскресенье":
        System.out.println("Воскресенье");
        break;
      default:
        System.out.println("Это не день недели");
    }
  }
}