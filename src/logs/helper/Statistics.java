package logs.helper;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;


@Getter
public class Statistics {
  private long totalTraffic;
  private LocalDateTime minTime;
  private LocalDateTime maxTime;
  private final HashSet<String> success = new HashSet<>();
  private final HashMap<String, Integer> systemHashMap = new HashMap<>();
  private final HashSet<String> notFound = new HashSet<>();
  private final HashMap<String, Integer> browserHashMap = new HashMap<>();
  private int visitFromUsers = 0;
  private int countError = 0;
  private final HashSet<String> uniqueUsers = new HashSet<>();
  //private final HashMap<String, Integer> realUser = new HashMap<>();
  private final HashMap<LocalDateTime, Integer> countRequestAtTheOneSec = new HashMap<>();
  //private final HashSet<String> domain = new HashSet<>();

  public Statistics() {
    this.totalTraffic = totalTraffic;
    this.minTime = minTime;
    this.maxTime = maxTime;
  }

  public void addEntry(LogEntry logEntries) {
    this.totalTraffic = this.totalTraffic + logEntries.getResponseSize();

    if (this.minTime == null) {
      this.minTime = logEntries.getDateTime();
    }

    this.maxTime = logEntries.getDateTime();

    if (logEntries.getResponseCode() == 200) {
      this.success.add(logEntries.getPath());
    } else if (logEntries.getResponseCode() == 404) {
      this.notFound.add(logEntries.getPath());
    }

    UserAgent userAgent = new UserAgent(logEntries.getUserAgent());

    //if (!userAgent.getTypeSystem().equals("none")) {
    if (systemHashMap.containsKey(userAgent.getTypeSystem())) {
      systemHashMap.put(userAgent.getTypeSystem(), systemHashMap.get(userAgent.getTypeSystem()) + 1);
    } else
      systemHashMap.put(userAgent.getTypeSystem(), 1);
    //}

    if (browserHashMap.containsKey(userAgent.getNameBrowser())) {
      browserHashMap.put(userAgent.getNameBrowser(), browserHashMap.get(userAgent.getNameBrowser()) + 1);
    } else
      browserHashMap.put(userAgent.getNameBrowser(), 1);

    if (!userAgent.getIsBot()) {
      visitFromUsers++;
      uniqueUsers.add(logEntries.getIpAddress());

      /*if (realUser.containsKey(logEntries.getIpAddress())) {
        realUser.put(logEntries.getIpAddress(), realUser.get(logEntries.getIpAddress()) + 1);
      } else
        realUser.put(logEntries.getIpAddress(), 1);*/

      if (countRequestAtTheOneSec.containsKey(logEntries.getDateTime())) {
        countRequestAtTheOneSec.put(logEntries.getDateTime(), countRequestAtTheOneSec.get(logEntries.getDateTime()) + 1);
      } else
        countRequestAtTheOneSec.put(logEntries.getDateTime(), 1);
    }

    if (logEntries.getResponseCode() <= 600 && logEntries.getResponseCode() >= 400) {
      this.countError++;
    }

  }


  public double getTrafficRate(LocalDateTime minTime, LocalDateTime maxTime) {
    LocalDateTime toDateTime = LocalDateTime.of(maxTime.getYear(), maxTime.getMonthValue(),
            maxTime.getDayOfMonth(), maxTime.getHour(),
            maxTime.getMinute(), maxTime.getSecond());

    LocalDateTime fromDateTime = LocalDateTime.of(minTime.getYear(), minTime.getMonthValue(),
            minTime.getDayOfMonth(), minTime.getHour(),
            minTime.getMinute(), minTime.getSecond());

    Period period = Period.between(fromDateTime.toLocalDate(), toDateTime.toLocalDate());
    Duration duration = Duration.between(fromDateTime.toLocalTime(), toDateTime.toLocalTime());


    double hours = period.getYears() * 8760 + period.getMonths() * 730.001 +
            period.getDays() * 24.000006575999520919 +
            duration.toHoursPart() + duration.toMinutesPart() * 0.016666671233333 +
            duration.toSecondsPart() * 0.00027777785388888336831;


    return (double) this.totalTraffic / hours;
  }

  public HashSet<String> getNotFoundPaths(ArrayList<LogEntry> logEntries) {
    HashSet<String> set = new HashSet<>();
    for (LogEntry logEntry : logEntries) {
      if (logEntry.getResponseCode() == 404) {
        set.add(logEntry.getPath());
      }
    }
    return set;
  }

  public HashSet<String> getAlLPath(ArrayList<LogEntry> logEntries) {
    HashSet<String> set = new HashSet<>();
    for (LogEntry logEntry : logEntries) {
      set.add(logEntry.getPath());
    }
    return set;
  }

  public HashMap<String, Double> getStaticOC(HashMap<String, Integer> stringIntegerHashMap, int size) {
    HashMap<String, Double> doubleHashMap = new HashMap<>();

    ArrayList<String> keys = new ArrayList<>(stringIntegerHashMap.keySet());
    ArrayList<Integer> values = new ArrayList<>(stringIntegerHashMap.values());

    for (int i = 0; i < stringIntegerHashMap.size(); i++) {
      doubleHashMap.put(keys.get(i), ((double) values.get(i) / size));
    }

    /*double n = 0;
    for (int i = 0; i < stringIntegerHashMap.size(); i++) {
      n = (double) values.get(i) / size + n;
    }
    System.out.println(n);*/

    return doubleHashMap;
  }

  public HashMap<String, Double> getStaticBrowser(HashMap<String, Integer> stringIntegerHashMap, int size) {
    HashMap<String, Double> doubleHashMap = new HashMap<>();

    ArrayList<String> keys = new ArrayList<>(stringIntegerHashMap.keySet());
    ArrayList<Integer> values = new ArrayList<>(stringIntegerHashMap.values());

    for (int i = 0; i < stringIntegerHashMap.size(); i++) {
      doubleHashMap.put(keys.get(i), ((double) values.get(i) / size));
    }

    /*double n = 0;
    for (int i = 0; i < stringIntegerHashMap.size(); i++) {
      n = (double) values.get(i) / size + n;
    }
    System.out.println(n);*/

    return doubleHashMap;
  }

  public double getAverageCountVisitSites(LocalDateTime minTime, LocalDateTime maxTime, int countVisit) {
    LocalDateTime toDateTime = LocalDateTime.of(maxTime.getYear(), maxTime.getMonthValue(),
            maxTime.getDayOfMonth(), maxTime.getHour(),
            maxTime.getMinute(), maxTime.getSecond());

    LocalDateTime fromDateTime = LocalDateTime.of(minTime.getYear(), minTime.getMonthValue(),
            minTime.getDayOfMonth(), minTime.getHour(),
            minTime.getMinute(), minTime.getSecond());

    Period period = Period.between(fromDateTime.toLocalDate(), toDateTime.toLocalDate());
    Duration duration = Duration.between(fromDateTime.toLocalTime(), toDateTime.toLocalTime());


    double hours = period.getYears() * 8760 + period.getMonths() * 730.001 +
            period.getDays() * 24.000006575999520919 +
            duration.toHoursPart() + duration.toMinutesPart() * 0.016666671233333 +
            duration.toSecondsPart() * 0.00027777785388888336831;


    return countVisit / hours;
  }


  public double getAverageCountError(LocalDateTime minTime, LocalDateTime maxTime, int countError) {
    LocalDateTime toDateTime = LocalDateTime.of(maxTime.getYear(), maxTime.getMonthValue(),
            maxTime.getDayOfMonth(), maxTime.getHour(),
            maxTime.getMinute(), maxTime.getSecond());

    LocalDateTime fromDateTime = LocalDateTime.of(minTime.getYear(), minTime.getMonthValue(),
            minTime.getDayOfMonth(), minTime.getHour(),
            minTime.getMinute(), minTime.getSecond());

    Period period = Period.between(fromDateTime.toLocalDate(), toDateTime.toLocalDate());
    Duration duration = Duration.between(fromDateTime.toLocalTime(), toDateTime.toLocalTime());


    double hours = period.getYears() * 8760 + period.getMonths() * 730.001 +
            period.getDays() * 24.000006575999520919 +
            duration.toHoursPart() + duration.toMinutesPart() * 0.016666671233333 +
            duration.toSecondsPart() * 0.00027777785388888336831;


    return hours / countError;
  }


  public double getStaticVisitRealUsers(int countVisitRealUser, int countRealUser) {
    return (double) countVisitRealUser / countRealUser;
  }

  public HashMap<LocalDateTime, Integer> getMaxVisitsAtTheSec(HashMap<LocalDateTime, Integer> countRequestAtTheOneSec) {
    Set<Map.Entry<LocalDateTime, Integer>> entrySet = countRequestAtTheOneSec.entrySet();
    HashMap<LocalDateTime, Integer> resultMap = new HashMap<>();
    ArrayList<Integer> integerArrayList = new ArrayList<>(countRequestAtTheOneSec.values());

    for (Map.Entry<LocalDateTime, Integer> pair : entrySet) {
      if (integerArrayList.stream().max(Comparator.naturalOrder()).get().equals(pair.getValue())) {
        resultMap.put(pair.getKey(), pair.getValue());
      }
    }
    return resultMap;
  }

  public HashSet<String> getAllDomain(ArrayList<LogEntry> logEntry) {
    HashSet<String> set = new HashSet<>();
    for (LogEntry entry : logEntry) {
      if (!entry.getReferer().equals("-")) {
        try {
          String[] str1 = entry.getReferer().split("://");
          String[] str2 = str1[1].split("/");
          set.add(str2[0]);
        } catch (Exception x) {
          System.out.println("!!!!!! Не смог распарсить: " + entry.getReferer());
        }
      }
    }
    return set;
  }

}
