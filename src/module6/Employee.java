package module6;

public class Employee {
  private String name;
  private String title;
  private String boss;

  @Override
  public String toString() {
    if (!name.equals(boss))
      return name + " работает в отделе " + title + ", начальник которого " + boss;
    else
      return boss + " начальник отдела " + title;
  }

  public Employee(String name, String title, String boss) {
    this.name = name;
    this.title = title;
    this.boss = boss;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBoss() {
    return boss;
  }

  public void setBoss(String boss) {
    this.boss = boss;
  }
}
