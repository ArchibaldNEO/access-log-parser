package logs.helper;

public class MainTest {
  public static void main(String[] args) {
    LogEntry logEntry = new LogEntry("162.140.234.113 - - " +
            "[25/Sep/2022:06:25:14 +0300] " +
            "\"GET /november-reports/politics/cosmetics/6378/06?n=18 HTTP/1.0\" " +
            "200 8815 \"-\" " +
            "\"Mozilla/5.0 AppleWebKit/537.36 (KHTML, like Gecko; compatible; bingbot/2.0; " +
            "+http://www.bing.com/bingbot.htm) Chrome/103.0.5060.134 Safari/537.36");

    System.out.println(logEntry.getIpAddress());
    System.out.println(logEntry.getDateTime());
    System.out.println(logEntry.getPath());
    System.out.println(logEntry.getHttpCode());
    System.out.println(logEntry.getSize());
    System.out.println(logEntry.getUserAgent());

    //System.out.println(stringToLocalDateTime("25/Sep/2022:06:25:14 +0300"));

  }
}
