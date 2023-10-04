import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number4 {
  public static void main(String[] args) throws IOException {
    System.out.print("Введите число: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();
    int d = Integer.parseInt(s);

    System.out.println("Результат: " + isPositive(d));
  }

  public static boolean isPositive(int x) {
    return x > 0;
  }
}