package module7;

import module5.ex1.Point;
import module5.ex2.Line;

import java.io.IOException;

public class MainTest {
  public static void main(String[] args) throws IOException {
    //Polymorphism1 polymorphism1 = new Polymorphism1(1, 24, 5);
    //System.out.println(polymorphism1);

    Polymorphism2 polymorphism_1 = new Polymorphism2(new Point(0, 0), new Point(0, 10));
    Polymorphism2 polymorphism_2 = new Polymorphism2(new Point(0, 10), new Point(5, 10));
    Polymorphism2 polymorphism_3 = new Polymorphism2(new Point(5, 10), new Point(5, 0));
    Polymorphism2 polymorphism_4 = new Polymorphism2(new Point(0, 5), new Point(0, 0));
    System.out.println(polymorphism_1);
    System.out.println(polymorphism_2);
    System.out.println(polymorphism_3);
    System.out.println(polymorphism_4);

    System.out.println(polymorphism_1.length());
    System.out.println(polymorphism_2.length());
    System.out.println(polymorphism_3.length());
    System.out.println(polymorphism_4.length());
    System.out.println(polymorphism_1.length(new Polymorphism2[]{polymorphism_1, polymorphism_2, polymorphism_3, polymorphism_3, polymorphism_4}));

  }
}
