package de.goat.tessatactoe;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Aufgabe1 {
  private WebDriver driver;
  JavascriptExecutor js;

  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver", "/home/soufian/WebDriver/bin/chromedriver");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  //Eigener Test Nr.4
  @Test
  public void test4() throws InterruptedException {
    driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");Thread.sleep(1000);
    driver.manage().window().setSize(new Dimension(1366, 768));
    driver.findElement(By.cssSelector("#player1-icon > .gwt-ListBox")).click();Thread.sleep(1000); {
      WebElement dropdown = driver.findElement(By.cssSelector("#player1-icon > .gwt-ListBox"));
      dropdown.findElement(By.xpath("//option[. = 'o']")).click();
    }
    driver.findElement(By.cssSelector("#player1-icon > .gwt-ListBox")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#player2-icon > .gwt-ListBox")).click();Thread.sleep(1000); {
      WebElement dropdown = driver.findElement(By.cssSelector("#player2-icon > .gwt-ListBox"));
      dropdown.findElement(By.xpath("//option[. = 'x']")).click();Thread.sleep(1000);
    }
    driver.findElement(By.cssSelector("#player2-icon > .gwt-ListBox")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-0 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-1 > .button")).click();Thread.sleep(1000); {
//      WebElement element = driver.findElement(By.cssSelector("#cell-1 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
    }
    driver.findElement(By.cssSelector("#cell-2 > .button")).click();
  }

  //Eigener Test Nr.5
  @Test
  public void test5() throws InterruptedException {
    driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
    driver.manage().window().setSize(new Dimension(1366, 768));Thread.sleep(2000);
    driver.findElement(By.cssSelector("#cell-0 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-1 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-2 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-3 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-4 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-9 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-8 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-7 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-6 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-5 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-19 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-18 > .button")).click(); 
//    {
//      WebElement element = driver.findElement(By.cssSelector("#cell-18 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
//    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
//    }
    driver.findElement(By.cssSelector("#cell-17 > .button")).click();Thread.sleep(1000); 
//    {
//      WebElement element = driver.findElement(By.cssSelector("#cell-17 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
//    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
//    }
    driver.findElement(By.cssSelector("#cell-16 > .button")).click();Thread.sleep(5000);
  }

  //Eigener Test Nr.9
  @Test
  public void test9() throws InterruptedException {
    driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
    driver.manage().window().setSize(new Dimension(1366, 768));Thread.sleep(2000);
    driver.findElement(By.cssSelector("#cell-0 > .button")).click();Thread.sleep(1000); 
//    {
//      WebElement element = driver.findElement(By.cssSelector("#cell-0 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
//    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
//    }
    driver.findElement(By.cssSelector("#cell-1 > .button")).click();Thread.sleep(1000); 
//    {
//      WebElement element = driver.findElement(By.cssSelector("#cell-1 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
//    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
//    }
    driver.findElement(By.cssSelector("#cell-5 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-10 > .button")).click();Thread.sleep(1000);
    driver.findElement(By.cssSelector("#cell-15 > .button")).click();Thread.sleep(1000); 
//    {
//      WebElement element = driver.findElement(By.cssSelector("#cell-15 > .button"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element).perform();Thread.sleep(1000);
//    } {
//      WebElement element = driver.findElement(By.tagName("body"));
//      Actions builder = new Actions(driver);
//      builder.moveToElement(element, 0, 0).perform();Thread.sleep(1000);
//    }
  }
}