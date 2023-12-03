import java.util.Scanner;

public class SumNew {
  public static void main(String[] args) {
    Integer sum = 0;

    for (int i = 0; i < args.length; i++) {
      if (new Scanner(args[i]).hasNextInt()) {
        sum = sum + Integer.parseInt(args[i]);
      }
    }
    System.out.println(sum);
  }
}
