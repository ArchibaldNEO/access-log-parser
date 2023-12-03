import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
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

      ArrayList<Integer> arrayList = new ArrayList<>();

      try {
        FileReader fileReader = new FileReader(path);
        BufferedReader reader = new BufferedReader(fileReader);
        String line;

        while ((line = reader.readLine()) != null) {
          int length = line.length();

          if (length > 1024) {
            throw new InvalidStringLenghtException("В файле встретилась строка длиннее 1024 символов");
          }

          arrayList.add(length);
        }

        System.out.println("Общее количество строк в файле: " + arrayList.size());
        System.out.println("Длина самой длинной строки в файле: " + arrayList.stream().max(Comparator.naturalOrder()).get());
        System.out.println("Длина самой короткой строки в файле: " + arrayList.stream().min(Comparator.naturalOrder()).get());

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}

