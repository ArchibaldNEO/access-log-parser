public class Sum {

  public static void main(String[] args) throws NumberFormatException {
    double sum = 0;
    for (int i = 0; i < args.length; i++) {
      sum += Double.parseDouble(args[i]);
    }
    System.out.println(sum);
  }
}

