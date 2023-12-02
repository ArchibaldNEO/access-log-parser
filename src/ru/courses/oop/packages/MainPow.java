import java.io.IOException;

public class MainPow {
  public static void main(String[] args) throws IOException {
    System.out.println("Результат возведения X в степень Y: " +
            Math.pow(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
  }
}

