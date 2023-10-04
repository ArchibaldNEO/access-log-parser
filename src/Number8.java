import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number8 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Введите a: ");
    String s1 = bufferedReader.readLine();
    int a = Integer.parseInt(s1);

    System.out.print("Введите b: ");
    String s2 = bufferedReader.readLine();
    int b = Integer.parseInt(s2);

    System.out.println("Результат: " + isDivisor(a, b));
  }

  public static boolean isDivisor(int a, int b) {
    return ((a % b == 0) || (b % a == 0));
  }
}