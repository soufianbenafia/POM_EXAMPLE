package de.goat.tessatactoe;

import org.junit.Test;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Aufgabe2 {
  private WebDriver driver;
  private TacToePage tacToePage;
  JavascriptExecutor js;

  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/home/soufian/WebDriver/bin/chromedriver");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
    js = (JavascriptExecutor) driver;
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void testCaseDreiPlayer1Result() throws InterruptedException {
	tacToePage = new TacToePage(driver);
    driver.manage().window().setSize(new Dimension(1366, 768)); Thread.sleep(2000);
    tacToePage.clickCell("0"); Thread.sleep(1000);
    tacToePage.clickCell("5"); Thread.sleep(1000);
    tacToePage.clickCell("1"); Thread.sleep(1000);
    tacToePage.clickCell("10");Thread.sleep(1000);
    tacToePage.clickCell("2"); Thread.sleep(1000);
    final String valuePlayer1 = tacToePage.getScorePlayer1();
    final String valuePlayer2 = tacToePage.getScorePlayer2();
    assertEquals("1", valuePlayer1);
    assertEquals("0", valuePlayer2);
  }

  @Test
  public void testCaseDreiPlayer2Result() throws InterruptedException {
    driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
    driver.manage().window().setSize(new Dimension(1366, 768));Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-0 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-1 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-5 > .button")).click();Thread.sleep(1000); 
//    {
//      WebElement element = driver.findElement(By.cssSelector("#cell-5 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
//    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
//    }
    driver.findElement(By.cssSelector("#cell-2 > .button")).click();Thread.sleep(1000);
//    {
//      WebElement element = driver.findElement(By.cssSelector("#cell-2 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
//    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
//    }
    driver.findElement(By.cssSelector("#cell-6 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-3 > .button")).click();Thread.sleep(1000);
    //driver.findElement(By.cssSelector(".gwt-Button")).click();Thread.sleep(1000);
    final String valuePlayer1 = driver.findElement(By.cssSelector("#score-1 > .gwt-Label")).getText();
    final String valuePlayer2 = driver.findElement(By.cssSelector("#score-2 > .gwt-Label")).getText();
    assertEquals("0", valuePlayer1);
    assertEquals("1", valuePlayer2);
  }
}