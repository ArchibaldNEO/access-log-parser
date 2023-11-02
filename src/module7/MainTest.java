package module7;

import module5.ex1.Point;
import module5.ex2.Line;

import java.io.IOException;

public class MainTest {
  public static void main(String[] args) throws IOException {
    //Polymorphism1 polymorphism1 = new Polymorphism1(1, 24, 5);
    //System.out.println(polymorphism1);

    Polymorphism2 polymorphism2 = new Polymorphism2(new Point[]{new Point(0, 0), new Point(0, 10),
            new Point(5, 10), new Point(5, 0), new Point(0, 0)});

    System.out.println(polymorphism2);

    System.out.println(polymorphism2.lenght());


  }
}
