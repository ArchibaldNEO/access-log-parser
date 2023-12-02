package ru.courses.oop.fraction;

import java.io.IOException;
import java.util.ArrayList;

public class MainDifficultFraction {
  public static void main(String[] args) throws IOException {
    DifficultFraction difficultFraction = new DifficultFraction(2);
    DifficultFraction difficultFraction2 = new DifficultFraction(3, 5);
    DifficultFraction difficultFraction3 = new DifficultFraction(2.3);

    ArrayList<DifficultFraction> arrayList1 = new ArrayList<>();
    arrayList1.add(difficultFraction);
    arrayList1.add(difficultFraction2);
    arrayList1.add(difficultFraction3);

    System.out.println("Итоговая сумма: " + sum(arrayList1));
    System.out.println();

    DifficultFraction difficultFraction4 = new DifficultFraction(3.6);
    DifficultFraction difficultFraction5 = new DifficultFraction(49, 12);
    DifficultFraction difficultFraction6 = new DifficultFraction(3);
    DifficultFraction difficultFraction7 = new DifficultFraction(3,2);

    ArrayList<DifficultFraction> arrayList2 = new ArrayList<>();
    arrayList2.add(difficultFraction4);
    arrayList2.add(difficultFraction5);
    arrayList2.add(difficultFraction6);
    arrayList2.add(difficultFraction7);

    System.out.println("Итоговая сумма: " + sum(arrayList2));
    System.out.println();

    DifficultFraction difficultFraction8 = new DifficultFraction(1,3);
    DifficultFraction difficultFraction9 = new DifficultFraction(1);

    ArrayList<DifficultFraction> arrayList3 = new ArrayList<>();
    arrayList3.add(difficultFraction8);
    arrayList3.add(difficultFraction9);

    System.out.println("Итоговая сумма: " + sum(arrayList3));


  }


  public static double sum(ArrayList<DifficultFraction> arrayList) {
    double sum = 0;
    for (DifficultFraction difficultFraction : arrayList) {
      sum = sum + difficultFraction.getDoublePart();
      System.out.println("Промежуточная сумма: " + sum);
    }

    return sum;

  }
}
