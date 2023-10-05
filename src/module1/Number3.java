package module1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number3 {
  public static void main(String[] args) throws IOException {
    System.out.print("Введите символ: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();

    System.out.println("Результат" + ": " + (char) charToNum(s.toCharArray()[0]));
  }

  public static int charToNum(char x) {
    return x;
  }
}