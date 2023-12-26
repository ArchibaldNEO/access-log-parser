package edu.innotech.pom;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class VictoryMainPage {
  WebDriver driver;
  By logo = By.xpath("//*[@id=\"__next\"]/div/header/div[1]/div[2]/div[1]/div/div[1]");
  By info = By.cssSelector("[href=\"/information\"]");
  By infoFlight = By.cssSelector("[href=\"/information#flight\"]");
  By infoUseful = By.cssSelector("[href=\"/information#useful\"]");
  By infoCompany = By.cssSelector("[href=\"/information#company\"]");

  public VictoryMainPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitlePage() {
    return driver.getTitle();
  }

  public Boolean getLogo() {
    return driver.findElement(logo).isDisplayed();
  }

  public WebElement info() {
    return driver.findElement(info);
  }

  public String getInfoFlight() {
    return driver.findElement(infoFlight).getText();
  }

  public String getInfoUseful() {
    return driver.findElement(infoUseful).getText();
  }

  public String getInfoCompany() {
    return driver.findElement(infoCompany).getText();
  }

}