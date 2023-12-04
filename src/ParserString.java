import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParserString {

  public Map<String, String> stringToMap(String someText) {
    String[] words = someText.split("\"");

    char[] charArray = words[0].toCharArray();
    String ipAddress = "";

    for (char c : charArray) {
      if (c != ' ') {
        ipAddress = ipAddress + c;
      } else
        break;
    }
    // System.out.println(ipAddress);

    int startDatetime = words[0].indexOf("[");
    int endDatetime = words[0].lastIndexOf("]");
    char[] charsDateTime = new char[endDatetime - startDatetime];
    String dateTime = "";
    someText.getChars(words[0].indexOf("["), words[0].lastIndexOf("]"), charsDateTime, 0);

    for (int i = 1; i < charsDateTime.length; i++) {
      dateTime = dateTime + charsDateTime[i];
    }
    // System.out.println(dateTime);

    String MethodPath = words[1];
    // System.out.println(MethodPath);

    String str = words[2].trim();
    String httpCode = str.substring(0, str.indexOf(" "));
    String size = str.substring(str.indexOf(" ") + 1);
    // System.out.println(httpCode);
    // System.out.println(size);

    String referer = words[3];
    //  System.out.println(referer);

    String userAgent = words[words.length - 1];
    //   System.out.println(userAgent);

    ArrayList<String> stringArrayList = new ArrayList<>();
    stringArrayList.add(ipAddress);
    stringArrayList.add(dateTime);
    stringArrayList.add(MethodPath);
    stringArrayList.add(httpCode);
    stringArrayList.add(size);
    stringArrayList.add(referer);
    stringArrayList.add(userAgent);

    HashMap<String, String> map = new HashMap<>();

    map.put("IP-адрес клиента", ipAddress);
    map.put("Дата и время запроса", dateTime);
    map.put("Метод запроса и путь", MethodPath);
    map.put("Код HTTP-ответа", httpCode);
    map.put("Размер отданных данных в байтах", size);
    map.put("Путь к странице, с которой перешли на текущую страницу", referer);
    map.put("User-Agent", userAgent);

    return map;
  }
}

