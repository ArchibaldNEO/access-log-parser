package edu.innotech;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {
  public static WebDriver driver;
  public String title = "Горячее – самые интересные и обсуждаемые посты | Пикабу";
  public String url = "https://pikabu.ru/";
  public String errorMessage = "Ошибка. Вы ввели неверные данные авторизации";
  public String logPass = "Qwerty";

  @BeforeAll
  public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "src/chromedriver");
    driver = new ChromeDriver();
  }

  @Test
  public void authorizationPikabuFail() {
    driver.get(url);

    Assertions.assertEquals(url, driver.getCurrentUrl());
    Assertions.assertEquals(title, driver.getTitle());

    driver.findElement(By.cssSelector(".header-right-menu__login-button")).click();

    driver.findElement(By.cssSelector(".popup__content")).isDisplayed();
    driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[1]/div/div")).isDisplayed();
    driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[2]/div/div")).isDisplayed();
    driver.findElement(By.xpath("//*[@id=\"signin-form\"]/div[7]/button")).isDisplayed();

    driver.findElement(By.xpath("//*[@class=\"popup__content\"]//div[1]/div/div/input")).sendKeys(logPass);
    driver.findElement(By.xpath("//*[@class=\"popup__content\"]//div[2]/div/div/input")).sendKeys(logPass);
    driver.findElement(By.xpath("//*[@class=\"popup__content\"]//div[7]/button")).click();

    Assertions.assertEquals(errorMessage, driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/div[1]/div/span")));

  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
}
