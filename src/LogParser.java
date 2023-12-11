import logs.helper.LogEntry;
import logs.helper.Statistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class LogParser {
  public static void main(String[] args) {
    int count = 0;

    Statistics statistics = new Statistics();
    HashSet<String> hashSet = new HashSet<>();
    ArrayList<LogEntry> logEntries = new ArrayList<>();

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
          LogEntry logEntry = new LogEntry(line);
          statistics.addEntry(logEntry);
          logEntries.add(logEntry);


          if (logEntry.getUserAgent().contains("Googlebot"))
            GoogleBot++;
          else if (logEntry.getUserAgent().contains("YandexBot"))
            YandexBot++;

        }

        if (arrayList.isEmpty()) {
          throw new InvalidEmptyException("Файл пуст");
        }

        System.out.println("Общее количество строк в файле: " + arrayList.size());
        System.out.println("GoogleBot: " + GoogleBot);
        System.out.println("YandexBot: " + YandexBot);
        System.out.println("Минимальная дата лога: " + statistics.getMinTime());
        System.out.println("Максимальная дата лога: " + statistics.getMaxTime());
        System.out.println("Общий объем трафика: " + statistics.getTotalTraffic());
        System.out.println("Объем часового трафика: " + statistics.getTrafficRate(statistics.getMinTime(), statistics.getMaxTime()));

        System.out.println("Iterating over list:");
        Iterator<String> i = statistics.getSet().iterator();
        while (i.hasNext())
          System.out.println(i.next());

        System.out.println(statistics.getAlLPath(logEntries).size());
        System.out.println(statistics.getSet().size());


      } catch (Exception ex) {
        ex.printStackTrace();
      }
//   /Users/askvortsov/Documents/Autotests_StepUP/master/access-log-parser/src/access.log

    }
  }
}

