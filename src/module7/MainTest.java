package module7;
import java.io.IOException;

public class MainTest {
  public static void main(String[] args) throws IOException {
    //Polymorphism1 polymorphism1 = new Polymorphism1(1, 24, 5);
    //System.out.println(polymorphism1);

    Polymorphism2 polymorphism2 = new Polymorphism2(new Point[]{new Point(1, 5), new Point(2, 8),
            new Point(5, 3), new Point(8, 9)});

    System.out.println(polymorphism2);

    System.out.println(polymorphism2.lenght1());


  }
}
