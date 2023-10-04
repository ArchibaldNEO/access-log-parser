import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Number1 {
  public static void main(String[] args) throws IOException {
    System.out.printf("Введите число: ");
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String s = bufferedReader.readLine();
    double d = Double.parseDouble(s);

    DecimalFormat dF = new DecimalFormat("#.###");
    System.out.println("Дробная часть числа (3 знака после запятой): " + dF.format(fraction(d)));
  }

  public static double fraction(double x) {
    return x - Math.floor(x);
  }
}