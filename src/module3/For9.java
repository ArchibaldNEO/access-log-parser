package module3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For9 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s1 = bufferedReader.readLine();
    int x = Integer.parseInt(s1);

    rightTriangle(x);
  }

  public static void rightTriangle(int x) {
    for (int i = 0; i < x; i++) {

      for (int j = 2*i; j < x + (x - 2); j++) {
        System.out.print(" ");
      }

      for (int j = i; j >= 0; j--) {
        System.out.print("*");
      }

      System.out.println();
    }
  }
}