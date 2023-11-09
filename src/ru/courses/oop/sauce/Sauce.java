package ru.courses.oop.sauce;


public class Sauce {
  private final String title;
  private final Hot hot;

  public Sauce(String title, Hot hots) {
    this.title = title;
    hot = hots;
  }

  @Override
  public String toString() {
    return "Соус " + title + " : " + hot;
  }


}

enum Hot {
  EXTRA_HOT("очень острый"), HOT("острый"), NOT_HOT("не острый");

  private final String title;

  Hot(String title) {
    this.title = title;
  }

  @Override
  public String toString() {
    return title;
  }
}






