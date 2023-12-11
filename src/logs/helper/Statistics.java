package logs.helper;

import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;


@Getter
public class Statistics {
  private long totalTraffic;
  private LocalDateTime minTime;
  private LocalDateTime maxTime;
  private final HashSet<String> set = new HashSet<>();

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
      this.set.add(logEntries.getPath());
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

  public HashSet<String> getAlLPath(ArrayList<LogEntry> logEntries) {
    HashSet<String> set = new HashSet<>();
    for (LogEntry logEntry : logEntries) {
      set.add(logEntry.getPath());
    }
    return set;
  }

}
