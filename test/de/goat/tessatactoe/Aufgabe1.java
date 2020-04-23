package de.goat.tessatactoe;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Aufgabe1 {
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
	public void player1Win() throws InterruptedException {
		// tacToePage.delay();
		tacToePage.clickCell("0");
		tacToePage.clickCell("7");
		tacToePage.clickCell("1");
		tacToePage.clickCell("8");
		tacToePage.clickCell("2");
		String val = tacToePage.getPlayerWon();
		assertEquals("player1 won the match!", val);
	}

	@Test
	public void player1Und2XToO() throws InterruptedException {
		// tacToePage.delay();
		tacToePage.chooseSignFromComboxPlayer1("o");
		tacToePage.chooseSignFromComboxPlayer2("x");
		assertEquals("x", tacToePage.getCurrentPlayer1Sign());
		assertEquals("o", tacToePage.getCurrentPlayer2Sign());
	}

	@Test
	public void diagonallyWin() throws InterruptedException {
		// tacToePage.delay();
		tacToePage.clickCell("0");
		tacToePage.clickCell("1");
		tacToePage.clickCell("2");
		tacToePage.clickCell("3");
		tacToePage.clickCell("4");
		tacToePage.clickCell("5");
		tacToePage.clickCell("10");
		tacToePage.clickCell("15");
		tacToePage.clickCell("6");
		String val = tacToePage.getPlayerWon();
		assertEquals("player1 won the match!", val);
	}

	@Test
	public void notEqualIcon() throws InterruptedException {
		// tacToePage.delay();
		tacToePage.chooseSignFromComboxPlayer1("o");
		final boolean notEqual = tacToePage.getCurrentPlayer1Sign().equals(tacToePage.getCurrentPlayer2Sign());
		assertFalse("equals icons is not correct", notEqual);
	}

}