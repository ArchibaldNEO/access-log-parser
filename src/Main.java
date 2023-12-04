import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    int count = 0;

    while (true) {
      System.out.print("Укажите путь к файлу: ");
      String path = new Scanner(System.in).nextLine();
      File file = new File(path);
      boolean fileExists = file.exists();
      boolean isDirectory = file.isDirectory();

      if (!fileExists || isDirectory) {
        System.out.println("Путь указан неверно");
        continue;
      }
      System.out.println("Путь указан верно");
      count++;
      System.out.println("Это файл номер " + count);


      try {
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int GoogleBot = 0;
        int YandexBot = 0;

        String line;

        while ((line = reader.readLine()) != null) {

          if (line.length() > 1024) {
            throw new InvalidStringLenghtException("В файле встретилась строка длиннее 1024 символов");
          }

          arrayList.add(line.length());

          ParserString parserString = new ParserString();

          String s1 = parserString.stringToMap(line).get("User-Agent");
          //System.out.println(s1);

          String s2 = parserString.searcherBot(s1);
         // System.out.println(s2);

          /*if (s1.contains("Googlebot"))
            GoogleBot++;
          else if (s1.contains("YandexBot"))
            YandexBot++;*/

          if (s2.equals("Googlebot"))
            GoogleBot++;
          else if (s2.equals("YandexBot"))
            YandexBot++;


        }

        if (arrayList.isEmpty()) {
          throw new InvalidEmptyException("Файл пуст");
        }

        System.out.println("Общее количество строк в файле: " + arrayList.size());
        System.out.println("GoogleBot: " + GoogleBot);
        System.out.println("YandexBot: " + YandexBot);

      } catch (Exception ex) {
        ex.printStackTrace();
      }


    }
  }
}

