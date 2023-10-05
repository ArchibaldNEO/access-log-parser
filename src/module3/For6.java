package module3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class For6 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("x: ");
    String s1 = bufferedReader.readLine();
    int x = Integer.parseInt(s1);

    System.out.println("Результат: " + equalNum(x));
  }

  public static boolean equalNum(int x) {
    String s = String.valueOf(x);
    char c = s.charAt(0);

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != c)
        return false;
    }
    return true;
  }
}