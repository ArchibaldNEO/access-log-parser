import java.io.IOException;

public class MainPow {
  public static void main(String[] args) throws IOException {
    for (int i = 0; i < 1; i++) {
      System.out.println("Результат возведения X в степень Y: " + pow(args[0], args[1]));
    }
  }

  public static int pow(String x, String y) {
    return (int) Math.pow(Integer.parseInt(x), Integer.parseInt(y));
  }
}

