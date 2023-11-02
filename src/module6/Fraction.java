package module6;

public class Fraction {
  private final int numerator;
  private final int denominator;

  public Fraction(int numerator, int denominator) {
    if (numerator < 0) {
      this.numerator = numerator;
      this.denominator = denominator;
    } else if (denominator < 0)
      throw new IllegalArgumentException();
    else {
      this.numerator = numerator;
      this.denominator = denominator;
    }
  }

  @Override
  public String toString() {
    return "числитель/знаменатель" + " = " + numerator + "/" + denominator;
  }

  public Fraction sum(Fraction a) {
    int x1 = this.numerator * a.denominator;
    int y1 = this.denominator * a.denominator;
    int x2 = a.numerator * this.denominator;
    int y2 = a.denominator * this.denominator;

    return new Fraction(x1 + x2, y1 + y2);

  }


  public Fraction minus(Fraction a) {
    int gcd = gcd(this.denominator, a.denominator);
    int nok = (this.denominator * a.denominator / gcd);

    if (this.denominator == a.denominator) {
      return new Fraction(this.numerator - a.numerator, a.denominator);
    } else {
      return new Fraction(this.numerator - a.denominator + a.numerator * this.denominator, nok);
    }
  }

  public Fraction minus(int n) {
    Fraction a = new Fraction(n, 1);
    int gcd = gcd(this.denominator, a.denominator);
    int nok = (this.denominator * a.denominator / gcd);

    if (this.denominator == a.denominator) {
      return new Fraction(this.numerator - a.numerator, a.denominator);
    } else {
      return new Fraction(this.numerator * a.denominator - a.numerator * this.denominator, nok);
    }
  }

  private static int gcd(int a, int b) {
    if (a == 0)
      return b;
    if (b == 0)
      return a;
    if (a >= b)
      return gcd(a % b, b);
    return gcd(a, b % a);
  }
}
