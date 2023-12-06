package logs.helper;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class LogEntry {
  private final String ipAddress;
  private final LocalDateTime dateTime;
  //final Type type;
  private final String path;
  private final int httpCode;
  private final int size;
  private final String referer;
  private final String userAgent;

  public LogEntry(String someText) {

    String[] words = someText.split("\"");

    char[] charArray = words[0].toCharArray();
    String ipAddress = "";

    for (char c : charArray) {
      if (c != ' ') {
        ipAddress = ipAddress + c;
      } else
        break;
    }

    int startDatetime = words[0].indexOf("[");
    int endDatetime = words[0].lastIndexOf("]");
    char[] charsDateTime = new char[endDatetime - startDatetime];
    String dateTime = "";
    someText.getChars(words[0].indexOf("["), words[0].lastIndexOf("]"), charsDateTime, 0);

    for (int i = 1; i < charsDateTime.length; i++) {
      dateTime = dateTime + charsDateTime[i];
    }


    String path = words[1];

    String str = words[2].trim();
    String httpCode = str.substring(0, str.indexOf(" "));
    String size = str.substring(str.indexOf(" ") + 1);

    String referer = words[3];

    String userAgent = words[words.length - 1];


    this.ipAddress = ipAddress;
    this.dateTime = stringToLocalDateTime(dateTime);
    //this.type = type;
    this.path = path;
    this.httpCode = Integer.parseInt(httpCode);
    this.size = Integer.parseInt(size);
    this.referer = referer;
    this.userAgent = userAgent;
  }


  public static LocalDateTime stringToLocalDateTime(String string) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    String string1 = string.substring(0, string.indexOf(" "));
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


enum Type {
  GET,
  POST,
  PUT,
  DELETE,
  PATCH,
  HEAD,
  OPTIONS,
  CONNECT,
  TRACE;
}

@Getter
enum Month {
  Jan("01"),
  Feb("02"),
  Mar("03"),
  Apr("04"),
  May("05"),
  Jun("06"),
  Jul("07"),
  Aug("08"),
  Sep("09"),
  Oct("10"),
  Nov("11"),
  Dec("12");

  private final String title;

  Month(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return "DayOfWeek{" +
            "title='" + title + '\'' +
            '}';
  }

}
