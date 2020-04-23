package de.goat.tessatactoe;

import org.junit.Test;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.NoSuchElementException;


public class Aufgabe2 {
	private WebDriver driver;
	private TacToePage tacToePage;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		tacToePage = new TacToePage(driver);
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void gewinnUeberEcke() throws InterruptedException {
		//tacToePage.delay();
		tacToePage.clickCell("10");
		tacToePage.clickCell("11");
		tacToePage.clickCell("12");
		tacToePage.clickCell("13");
		tacToePage.clickCell("16");
		tacToePage.clickCell("17");
		tacToePage.clickCell("18");
		driver.findElement(By.cssSelector("#cell-16 img")).click();
		driver.findElement(By.cssSelector("#cell-13 img")).click();
		String val = tacToePage.getPlayerWon();
		assertEquals("player1 won the match!", val);
	}

	@Test(expected = NoSuchElementException.class)
	public void backslash() throws InterruptedException {
		//tacToePage.delay();
		tacToePage.clickCell("2");
		tacToePage.clickCell("5");
		tacToePage.clickCell("8");
		tacToePage.clickCell("10");
		tacToePage.clickCell("14");
		tacToePage.clickCell("10");
		tacToePage.getPlayerWon();
	}
}