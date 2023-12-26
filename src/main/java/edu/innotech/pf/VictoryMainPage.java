package edu.innotech.pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VictoryMainPage {
  WebDriver driver;

  @FindBy(xpath = "//*[@id=\"__next\"]/div/header/div[1]/div[2]/div[1]/div/div[1]")
  WebElement logo;

  @FindBy(css = "[href=\"/information\"]")
  WebElement info;

  @FindBy(css = "[href=\"/information#flight\"]")
  WebElement infoFlight;

  @FindBy(css = "[href=\"/information#useful\"]")
  WebElement infoUseful;

  @FindBy(css = "[href=\"/information#company\"]")
  WebElement infoCompany;


  public VictoryMainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String getTitlePage() {
    return driver.getTitle();
  }

  public Boolean getLogo() {
    return logo.isDisplayed();
  }

  public WebElement info() {
    return info;
  }

  public String getInfoFlight() {
    return infoFlight.getText();
  }

  public String getInfoUseful() {
    return infoUseful.getText();
  }

  public String getInfoCompany() {
    return infoCompany.getText();
  }

}
