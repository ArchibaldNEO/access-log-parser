package logs.helper;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class LogEntry {
  private final String ipAddress;
  private final LocalDateTime dateTime;
  private final HttpMethod httpMethod;
  private final String path;
  private final int responseCode;
  private final int responseSize;
  private final String referer;
  private final String userAgent;

  public LogEntry(String stringLog) {
    this.ipAddress = stringToIpAddress(stringLog);
    this.dateTime = stringToLocalDateTime(stringLog);
    this.httpMethod = stringToHttpMethod(stringLog);
    this.path = stringToPath(stringLog);
    this.responseCode = stringToResponseCode(stringLog);
    this.responseSize = stringToResponseSize(stringLog);
    this.referer = stringToReferer(stringLog);
    this.userAgent = stringToUserAgent(stringLog);
  }

  public static String stringToUserAgent(String stringLog) {
    String[] stringLogs = stringLog.split("\"");
    return stringLogs[stringLogs.length - 1];
  }

  public static String stringToReferer(String stringLog) {
    String[] stringLogs = stringLog.split("\"");
    return stringLogs[3];
  }

  public static int stringToResponseSize(String stringLog) {
    String[] stringLogs = stringLog.split("\"");
    String str = stringLogs[2].trim();
    String size = str.substring(str.indexOf(" ") + 1);
    return Integer.parseInt(size);
  }

  public static int stringToResponseCode(String stringLog) {
    String[] stringLogs = stringLog.split("\"");
    String str = stringLogs[2].trim();
    String httpCode = str.substring(0, str.indexOf(" "));
    return Integer.parseInt(httpCode);
  }

  public static String stringToPath(String stringLog) {
    String[] stringLogs = stringLog.split("\"");
    String methodAndPath = stringLogs[1];
    String[] strings = methodAndPath.split(" ");

    StringBuilder path = new StringBuilder();
    for (int i = 1; i < strings.length; i++) {
      path.append(strings[i]).append(" ");
    }
    return path.toString().trim();
  }

  public static String stringToIpAddress(String stringLog) {
    String[] stringLogs = stringLog.split("\"");
    char[] charArray = stringLogs[0].toCharArray();
    String ipAddress = "";

    for (char c : charArray) {
      if (c != ' ') {
        ipAddress = ipAddress + c;
      } else
        break;
    }
    return ipAddress;
  }

  public static HttpMethod stringToHttpMethod(String stringLog) {
    String[] stringLogs = stringLog.split("\"");
    String methodAndPath = stringLogs[1];
    String[] strings = methodAndPath.split(" ");

    HttpMethod httpMethod = null;
    switch (strings[0]) {
      case "GET":
        httpMethod = HttpMethod.GET;
        break;
      case "POST":
        httpMethod = HttpMethod.POST;
        break;
      case "PUT":
        httpMethod = HttpMethod.PUT;
        break;
      case "PATCH":
        httpMethod = HttpMethod.PATCH;
        break;
      case "OPTIONS":
        httpMethod = HttpMethod.OPTIONS;
        break;
      case "TRACE":
        httpMethod = HttpMethod.TRACE;
        break;
      case "CONNECT":
        httpMethod = HttpMethod.CONNECT;
        break;
      case "DELETE":
        httpMethod = HttpMethod.DELETE;
        break;
      case "HEAD":
        httpMethod = HttpMethod.HEAD;
        break;
    }
    return httpMethod;
  }


  public static LocalDateTime stringToLocalDateTime(String stringLog) {
    String[] someTexts = stringLog.split("\"");


    int startDatetime = someTexts[0].indexOf("[");
    int endDatetime = someTexts[0].lastIndexOf("]");
    char[] charsDateTime = new char[endDatetime - startDatetime];
    StringBuilder dateTime = new StringBuilder();
    stringLog.getChars(someTexts[0].indexOf("["), someTexts[0].lastIndexOf("]"), charsDateTime, 0);

    for (int i = 1; i < charsDateTime.length; i++) {
      dateTime.append(charsDateTime[i]);
    }


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String string1 = dateTime.substring(0, dateTime.indexOf(" "));
    String[] strings = string1.split(":");
    String[] string3 = strings[0].split("/");

    switch (string3[1]) {
      case "Jan":
        string3[1] = Month.Jan.getTitle();
        break;
      case "Feb":
        string3[1] = Month.Feb.getTitle();
        break;
      case "Mar":
        string3[1] = Month.Mar.getTitle();
        break;
      case "Apr":
        string3[1] = Month.Apr.getTitle();
        break;
      case "May":
        string3[1] = Month.May.getTitle();
        break;
      case "Jun":
        string3[1] = Month.Jun.getTitle();
        break;
      case "Jul":
        string3[1] = Month.Jul.getTitle();
        break;
      case "Aug":
        string3[1] = Month.Aug.getTitle();
        break;
      case "Sep":
        string3[1] = Month.Sep.getTitle();
        break;
      case "Oct":
        string3[1] = Month.Oct.getTitle();
        break;
      case "Nov":
        string3[1] = Month.Nov.getTitle();
        break;
      case "Dec":
        string3[1] = Month.Dec.getTitle();
        break;

    }

    String finalString = string3[2] + "-" + string3[1] + "-" + string3[0] + " "
            + strings[1] + ":" + strings[2] + ":" + strings[3];

    return LocalDateTime.parse(finalString, formatter);
  }
}


