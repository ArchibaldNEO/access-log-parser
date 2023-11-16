public class Sum
{
  public static void main(String[] args) {
    double sum = 0;
    double d = 0;
    for (int i = 0; i < args.length; i++) {
      try {
        d = Double.parseDouble(args[i]);
      } catch (NumberFormatException e) {
        System.out.println(e);
        d = 0;
      }
      sum += d;
    }
    System.out.println(sum);
  }
}

