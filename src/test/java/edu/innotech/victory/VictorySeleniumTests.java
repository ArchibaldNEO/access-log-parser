package edu.innotech.victory;

import edu.innotech.pf.VictoryMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class VictorySeleniumTests {

  private static WebDriver driver;
  private static Actions action;
  private static WebDriverWait wait;

  @BeforeAll
  public static void setUp() {
    ChromeOptions options = new ChromeOptions();
    System.setProperty("webdriver.chrome.driver", "src/chromedriver");
    driver = new ChromeDriver(options);
    driver.get("https://pobeda.aero/");
    action = new Actions(driver);
  }


  @Test
  public void firstVictory() {
    VictoryMainPage victoryMainPage = new VictoryMainPage(driver);

    Assertions.assertEquals("Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками", victoryMainPage.getTitlePage());

    Assertions.assertTrue(victoryMainPage.getLogo());

    action.moveToElement(victoryMainPage.info());
    action.perform();

    Assertions.assertEquals("Подготовка к полёту", victoryMainPage.getInfoFlight());
    Assertions.assertEquals("Полезная информация", victoryMainPage.getInfoUseful());
    Assertions.assertEquals("О компании", victoryMainPage.getInfoCompany());

  }


  @AfterAll
  public static void tearDown() {
    driver.quit();
  }

}
