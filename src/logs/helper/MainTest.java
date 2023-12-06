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
    System.out.println(logEntry.getHttpMethod());
    System.out.println(logEntry.getPath());
    System.out.println(logEntry.getResponseCode());
    System.out.println(logEntry.getResponseSize());
    System.out.println(logEntry.getReferer());
    System.out.println(logEntry.getUserAgent());

    System.out.println();

    UserAgent userAgent1 = new UserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_2) " +
            "AppleWebKit/536.26.17 (KHTML, like Gecko) Version/6.0.2 Safari/536.26.17");
    UserAgent userAgent2 = new UserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/536.6 " +
            "(KHTML, like Gecko) Chrome/20.0.1092.0 Safari/536.6");
    UserAgent userAgent3 = new UserAgent("Mozilla/5.0 (Linux; Android 6.0.1; Nexus 5X Build/MMB29P) AppleWebKit/537.36 (KHTML, like Gecko) " +
            "Chrome/105.0.5195.125 Mobile Safari/537.36 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)");
    UserAgent userAgent4 = new UserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0");
    UserAgent userAgent5 = new UserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.100 Safari/537.36");
    UserAgent userAgent6 = new UserAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 " +
            "(KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36 OPR/67.0.3575.79");
    UserAgent userAgent7 = new UserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 " +
            "(KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36 Edge/18.18362");
    UserAgent userAgent8 = new UserAgent("Mozilla/5.0 (iPhone; CPU iPhone OS 13_5_1 like Mac OS X)" +
            " AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.1.1 Mobile/15E148 Safari/604.1");

    UserAgent userAgent9 = new UserAgent("Mozilla/5.0 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)");
    UserAgent userAgent10 = new UserAgent("curl/7.60.0");

    System.out.println(userAgent1.getTypeSystem() + " " + userAgent1.getNameBrowser());


  }


  public static String identifyBrowser(String s) {
    if (s.contains("Chrome") && s.contains("Safari") && s.contains("Edge"))
      return "Edge";
    else if (s.contains("Chrome") && s.contains("Safari") && s.contains("OPR"))
      return "OPR";
    else if (s.contains("Chrome") && s.contains("Safari"))
      return "Chrome";
    else if (s.contains("Firefox"))
      return "Firefox";
    else if (s.contains("Safari"))
      return "Safari";
    else if (s.contains("compatible"))
      return "compatible";
    else if (s.contains("curl"))
      return "curl";
    else
      return "PostmanRuntime";
  }

  public static String identifySystem(String s) {
    if (s.contains("Linux"))
      return "Linux";
    else if (s.contains("Windows"))
      return "Windows";
    else if (s.contains("Mac"))
      return "macOS";
    else
      return "none";
  }
}
