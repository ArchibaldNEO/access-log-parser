import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    System.out.println("Введите первое число:");

    BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));

    String s1 = bufferedReader1.readLine(); //читаем строку с клавиатуры
    int x1 = Integer.parseInt(s1);//преобразовываем строку в число.

    System.out.println("Введите второе число:");

    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
    String s2 = bufferedReader2.readLine(); //читаем строку с клавиатуры

    int x2 = Integer.parseInt(s2);//преобразовываем строку в число.


    System.out.println("Сумма чисел = " + (x1 + x2));
    System.out.println("Разность чисел = " + (x1 - x2));
    System.out.println("Произведение чисел = " + (x1 * x2));
    double i = (double) x1 /x2;
    System.out.println("Частное чисел = " + i);

  }
}