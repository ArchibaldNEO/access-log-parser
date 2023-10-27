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

  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  public Fraction sum(Fraction a) {
    int gcd = gcd(this.getDenominator(), a.getDenominator());
    int nok = (this.getDenominator() * a.getDenominator() / gcd);

    if (this.getDenominator() == a.getDenominator()) {
      return new Fraction(this.getNumerator() + a.getNumerator(), a.getDenominator());
    } else {
      return new Fraction(this.getNumerator() * a.getDenominator() + a.getNumerator() * this.getDenominator(), nok);
    }
  }

  public Fraction minus(Fraction a) {
    int gcd = gcd(this.getDenominator(), a.getDenominator());
    int nok = (this.getDenominator() * a.getDenominator() / gcd);

    if (this.getDenominator() == a.getDenominator()) {
      return new Fraction(this.getNumerator() - a.getNumerator(), a.getDenominator());
    } else {
      return new Fraction(this.getNumerator() - a.getDenominator() + a.getNumerator() * this.getDenominator(), nok);
    }
  }

  public Fraction minus(int n) {
    Fraction a = new Fraction(n, 1);
    int gcd = gcd(this.getDenominator(), a.getDenominator());
    int nok = (this.getDenominator() * a.getDenominator() / gcd);

    if (this.getDenominator() == a.getDenominator()) {
      return new Fraction(this.getNumerator() - a.getNumerator(), a.getDenominator());
    } else {
      return new Fraction(this.getNumerator() * a.getDenominator() - a.getNumerator() * this.getDenominator(), nok);
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
