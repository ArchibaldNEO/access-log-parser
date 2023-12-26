package edu.innotech.pf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

  @FindBy(css = "[placeholder=\"Откуда\"]")
  WebElement from;

  @FindBy(css = ".dp-eptrrl-root")
  WebElement firstVariant;

  @FindBy(css = "[placeholder=\"Куда\"]")
  WebElement to;

  @FindBy(css = "[placeholder=\"Туда\"]")
  WebElement fromDate;

  @FindBy(css = "[placeholder=\"Обратно\"]")
  WebElement toDate;

  @FindBy(css = ".dp-ew66p9-root-root")
  WebElement search;

  @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[1]/div[2]/button[3]")
  WebElement manageBooking;

  @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[1]/div[1]/div/input")
  WebElement secondNameClient;

  @FindBy(css = "[placeholder=\"Номер заказа или билета\"]")
  WebElement numberOrder;

  @FindBy(css = ".dp-1dtx37h-root-root")
  WebElement searchInManageBooking;

  @FindBy(xpath = "//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div/div[2]/form/div/div[2]/div[1]/div[2]")
  WebElement orderNotFound;

  public VictoryMainPage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public String getTitlePage() {
    return driver.getTitle();
  }

  public Boolean isDisplayedLogo() {
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

  public boolean isDisplayedFrom() {
    return from.isDisplayed();
  }

  public boolean isDisplayedTo() {
    return to.isDisplayed();
  }

  public boolean isDisplayedFromDate() {
    return fromDate.isDisplayed();
  }

  public boolean isDisplayedToDate() {
    return toDate.isDisplayed();
  }

  public void setFrom(String text) {
    from.sendKeys(text);
    firstVariant.click();
  }

  public void setTo(String text) {
    to.sendKeys(text);
    firstVariant.click();
  }

  public void clickSearch() {
    try {
      search.click();
    } catch (Exception ex) {
      System.out.println("Кнопка " + search.getText() + " некликабельная");
    }

  }

  public void clickManageBooking() {
    try {
      manageBooking.click();
    } catch (Exception ex) {
      System.out.println("Кнопка " + manageBooking.getText() + " некликабельная");
    }

  }


  public void setSecondNameClient(String text) {
    secondNameClient.sendKeys(text);
  }

  public void setNumberOrder(String text) {
    numberOrder.sendKeys(text);
  }

  public void clickSearchInManageBooking() {
    try {
      searchInManageBooking.click();
    } catch (Exception ex) {
      System.out.println("Кнопка " + searchInManageBooking.getText() + " некликабельная");
    }

  }

  public boolean isDisplayedSecondNameClient() {
    return secondNameClient.isDisplayed();
  }

  public boolean isDisplayedNumberOrder() {
    return numberOrder.isDisplayed();
  }

  public boolean isDisplayedSearchInManageBooking() {
    return searchInManageBooking.isDisplayed();
  }

  public String getOrderNotFound() {
    return orderNotFound.getText();
  }

}
