package logs.helper;

import java.util.HashMap;
import java.util.Map;

public class ParserString {

  public Map<String, String> stringToMap(String someText) {
    HashMap<String, String> map = new HashMap<>();
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
    StringBuilder dateTime = new StringBuilder();
    someText.getChars(words[0].indexOf("["), words[0].lastIndexOf("]"), charsDateTime, 0);

    for (int i = 1; i < charsDateTime.length; i++) {
      dateTime.append(charsDateTime[i]);
    }

    String path = words[1];

    String str = words[2].trim();
    String httpCode = str.substring(0, str.indexOf(" "));
    String size = str.substring(str.indexOf(" ") + 1);

    String referer = words[3];

    String userAgent = words[words.length - 1];

    map.put("IP-адрес клиента", ipAddress);
    map.put("Дата и время запроса", dateTime.toString());
    map.put("Метод запроса и путь", path);
    map.put("Код HTTP-ответа", httpCode);
    map.put("Размер отданных данных в байтах", size);
    map.put("Путь к странице, с которой перешли на текущую страницу", referer);
    map.put("User-Agent", userAgent);

    return map;
  }

  public String searcherBot(String someText) {
    String s1 = "";
    if (someText.length() > 1) {
      try {
        s1 = someText.substring(someText.indexOf("("));
      } catch (Exception e) {
      }
    }

    String s2 = "";
    char[] characterArrayList1 = s1.toCharArray();
    for (int i = 0; i < characterArrayList1.length; i++) {
      if (characterArrayList1[i] != ')') {
        s2 = s2 + characterArrayList1[i];
      } else {
        s2 = s2 + characterArrayList1[i];
        break;
      }
    }


    String[] parts = s2.split(";");


    char[] characterArrayList2 = new char[1];
    String s3 = "";
    String s4 = "";
    if (parts.length >= 2) {
      characterArrayList2 = parts[1].toCharArray();
      for (int i = 0; i < characterArrayList2.length; i++) {
        if (characterArrayList2[i] != ' ') {
          s3 = s3 + characterArrayList2[i];
        }
      }

      char[] characterArrayList3 = s3.toCharArray();
      for (int i = 0; i < characterArrayList3.length; i++) {
        if (characterArrayList3[i] != '/') {
          s4 = s4 + characterArrayList3[i];
        } else
          break;
      }
    }
    return s4;
  }


}

