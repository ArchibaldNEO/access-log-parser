import logs.helper.LogEntry;
import logs.helper.Statistics;
import myself.exceptions.InvalidEmptyException;
import myself.exceptions.InvalidStringLenghtException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class LogParserMain {
  public static void main(String[] args) {
    int count = 0;

    Statistics statistics = new Statistics();
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
        int bot = 0;
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

          if (logEntry.getUserAgent().contains("bot"))
            bot++;

        }

        if (arrayList.isEmpty()) {
          throw new InvalidEmptyException("Файл пуст");
        }

        System.out.println("Общее количество строк в файле: " + arrayList.size());
        System.out.println("GoogleBot: " + GoogleBot);
        System.out.println("YandexBot: " + YandexBot);
        System.out.println("Сколько всего запросов от ботов: " + bot);
        System.out.println("Минимальная дата лога: " + statistics.getMinTime());
        System.out.println("Максимальная дата лога: " + statistics.getMaxTime());
        System.out.println("Общий объем трафика: " + statistics.getTotalTraffic());
        System.out.println("Объем часового трафика: " + statistics.getTrafficRate(statistics.getMinTime(), statistics.getMaxTime()));
        System.out.println("Количество каждой ОС : " + statistics.getSystemHashMap());
        System.out.println("Доля каждой ОС от общего числа : " + statistics.getStaticOC(statistics.getSystemHashMap(), arrayList.size()));
        System.out.println("Количество каждого браузера : " + statistics.getBrowserHashMap());
        System.out.println("Доля каждой браузера от общего числа : " + statistics.getStaticBrowser(statistics.getBrowserHashMap(), arrayList.size()));
        System.out.println("Подсчёт среднего количества посещений сайта за час : " + statistics.getAverageCountVisitSites(statistics.getMinTime(),
                statistics.getMaxTime(), statistics.getVisitFromUsers()));

        System.out.println("Количество запросов, по которым был ошибочный код ответа (4xx или 5xx): " + statistics.getCountError());
        System.out.println("Подсчёт среднего количества ошибочных запросов в час: " +
                statistics.getAverageCountVisitSites(statistics.getMinTime(),
                        statistics.getMaxTime(), statistics.getCountError()));

        System.out.println("Количество посещений от реальных пользователей: " + statistics.getVisitFromUsers());
        System.out.println("Количество уникальных реальных пользователей: " + statistics.getUniqueUsers().size());
        //System.out.println(statistics.getRealUser().values());

        System.out.println("Расчёта средней посещаемости одним пользователем: " +
                statistics.getStaticVisitRealUsers(statistics.getVisitFromUsers(), statistics.getUniqueUsers().size()));

        //System.out.println(statistics.getNotFound().size());
        //System.out.println(statistics.getNotFoundPaths(logEntries).size());


        System.out.println("Расчёта пиковой посещаемости сайта (в секунду): " + statistics.getMaxVisitsAtTheSec(statistics.getCountRequestAtTheOneSec()));

        System.out.println("Cписок сайтов, со страниц которых есть ссылки на текущий сайт: "
                + statistics.getAllDomain(logEntries));

        System.out.println("Расчёта максимальной посещаемости одним пользователем: " +
                statistics.getMaxCountVisitOneUser(statistics.getRealUser()));

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }
}
//   /Users/askvortsov/Documents/Autotests_StepUP/master/access-log-parser/src/data/files/access.log

