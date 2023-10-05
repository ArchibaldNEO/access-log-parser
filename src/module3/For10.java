package module3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For10 {
  public static void main(String[] args) throws IOException {
    guessGame();
  }

  public static void guessGame() {
    int randomNum = 3;
    int count = 1;

    java.util.Scanner sc = new java.util.Scanner(System.in);
    System.out.print("What number am I thinking (0 to 9)? : ");
    int x = sc.nextInt();

    while (x != randomNum) {
      System.out.println("No, try again");
      count++;
      System.out.print("What number am I thinking (0 to 9)? : ");
      x = sc.nextInt();
    }
    System.out.println("Yes, it`s " + randomNum);
    System.out.println("Количество попыток: " + count);
  }
}
