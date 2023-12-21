package edu.innotech;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WebTest {
  private static WebDriver driver;
  private static WebDriverWait wait;
  public String title = "Горячее – самые интересные и обсуждаемые посты | Пикабу";
  public String url = "https://pikabu.ru/";
  public String errorMessage = "Ошибка. Вы ввели неверные данные авторизации";
  public String logPass = "Qwerty";


  public String googleUrl = "https://www.google.com/";

  @BeforeAll
  public static void setUp() {
    ChromeOptions options = new ChromeOptions();
    System.setProperty("webdriver.chrome.driver", "src/chromedriver");
    driver = new ChromeDriver(options);
    wait = new WebDriverWait(driver, Duration.ofMillis(40000));
    driver.manage().timeouts().implicitlyWait(40000, TimeUnit.MILLISECONDS);
    driver.manage().timeouts().pageLoadTimeout(40000, TimeUnit.MILLISECONDS);
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

  @Test
  public void goToPodeda() {
    driver.get(googleUrl);

    driver.findElement(By.cssSelector("[type=\"search\"]")).sendKeys("Сайт компании Победа");
    driver.findElement(By.cssSelector("[type=\"search\"]")).sendKeys(Keys.ENTER);
    driver.findElement(By.cssSelector(".LC20lb")).click();

    Assertions.assertEquals("Полетели в Дубай!",
            driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[1]/div/div[1]/button[3]/div[3]/div/div")).getText());


    driver.findElement(By.cssSelector(".dp-1c04wlv-root-root")).click();
    driver.findElement(By.xpath("/html/body/div[4]/div/div/button[2]")).click();

    Assertions.assertEquals("Ticket search",
            driver.findElement(By.xpath("//*[@id=\"__next\"]//div[2]/button[1]/div[1]")).getText());
    Assertions.assertEquals("Online check-in",
            driver.findElement(By.xpath("//*[@id=\"__next\"]//div[2]/button[2]/div[1]")).getText());
    Assertions.assertEquals("Manage my booking",
            driver.findElement(By.xpath("//*[@id=\"__next\"]//div[2]/button[3]/div[1]")).getText());

  }

  @AfterAll
  public static void tearDown() {
    driver.quit();
  }
}