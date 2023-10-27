package module6;

import java.io.IOException;

public class MainFraction {
  public static void main(String[] args) throws IOException {
    Fraction f1 = new Fraction(1, 3);
    Fraction f2 = new Fraction(2, 5);
    Fraction f3 = new Fraction(7, 8);

    //System.out.println(f1.sum(f2));
    //System.out.println(f1.sum(f2).sum(f3));
    System.out.println(f1.sum(f2).sum(f3).minus(5));
  }
}
