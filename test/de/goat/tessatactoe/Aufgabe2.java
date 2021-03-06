package de.goat.tessatactoe;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class Aufgabe2 {
	private WebDriver driver;
	private TacToePage tacToePage;

	@Before
	public void setUp() {
		// System.setProperty("webdriver.chrome.driver","C:/WebDriver/bin/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/home/soufian/WebDriver/bin/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		tacToePage = new TacToePage(driver);
		new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cell-18 > .button")));
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void gewinnUeberEcke() {
		tacToePage.clickCell(10);
		tacToePage.clickCell(11);
		tacToePage.clickCell(12);
		tacToePage.clickCell(13);
		tacToePage.clickCell(16);
		tacToePage.clickCell(17);
		tacToePage.clickCell(18);
		driver.findElement(By.cssSelector("#cell-16 img")).click();
		driver.findElement(By.cssSelector("#cell-13 img")).click();
		String val = tacToePage.getPlayerWon();
		assertEquals("player1 won the match!", val);
	}

	@Test(expected = NoSuchElementException.class)
	public void backslash() {
		// tacToePage.delay();
		tacToePage.clickCell(2);
		tacToePage.clickCell(5);
		tacToePage.clickCell(8);
		tacToePage.clickCell(10);
		tacToePage.clickCell(14);
		tacToePage.clickCell(10);
		tacToePage.getPlayerWon();
	}

	@Test
	public void playerBiuld_V() {
		// tacToePage.delay();
		tacToePage.clickCell(0);
		tacToePage.clickCell(1);
		tacToePage.clickCell(6);
		tacToePage.clickCell(7);
		tacToePage.clickCell(2);

		String val1 = tacToePage.getScorePlayer1();
		String val2 = tacToePage.getScorePlayer2();
		assertEquals("0", val1);
		assertEquals("0", val2);
	}

	@Test
	public void inpossibleWin() {
		tacToePage.clickCell(0);
		tacToePage.clickCell(1);
		tacToePage.clickCell(2);
		tacToePage.clickCell(3);
		tacToePage.clickCell(4);
		tacToePage.clickCell(6);
		tacToePage.clickCell(5);
		tacToePage.clickCell(8);
		tacToePage.clickCell(7);
		tacToePage.clickCell(10);
		tacToePage.clickCell(9);
		tacToePage.clickCell(12);
		tacToePage.clickCell(11);
		tacToePage.clickCell(14);
		tacToePage.clickCell(13);
		tacToePage.clickCell(15);
		tacToePage.clickCell(16);
		tacToePage.clickCell(17);
		tacToePage.clickCell(18);
		String val1 = tacToePage.getScorePlayer1();
		String val2 = tacToePage.getScorePlayer2();
		assertEquals("0", val1);
		assertEquals("0", val2);
	}

	@Test
	public void testCaseDreiPlayer1Result() {
		tacToePage = new TacToePage(driver);
		tacToePage.clickCell(0);
		tacToePage.clickCell(5);
		tacToePage.clickCell(1);
		tacToePage.clickCell(10);
		tacToePage.clickCell(2);
		final String valuePlayer1 = tacToePage.getScorePlayer1();
		final String valuePlayer2 = tacToePage.getScorePlayer2();
		assertEquals("1", valuePlayer1);
		assertEquals("0", valuePlayer2);
	}

	@Test
	public void testCaseDreiPlayer2Result() {
		tacToePage.clickCell(0);
		tacToePage.clickCell(1);
		tacToePage.clickCell(5);
		tacToePage.clickCell(2);
		tacToePage.clickCell(6);
		tacToePage.clickCell(3);
		final String valuePlayer1 = tacToePage.getScorePlayer1();
		final String valuePlayer2 = tacToePage.getScorePlayer2();
		assertEquals("0", valuePlayer1);
		assertEquals("1", valuePlayer2);
	}

	@Test
	public void Feldmerhmalsklicken() {
		int i = 30;
		while (i > 0) {

			tacToePage.clickCell(7);
			i--;
		}
	}

	@Test
	public void HorizontalSpalte4() {

		// horizontal4Spalte
		tacToePage.clickCell(4);
		tacToePage.clickCell(0);
		tacToePage.clickCell(9);
		tacToePage.clickCell(5);
		tacToePage.clickCell(14);

		assertTrue(tacToePage.closeButtonAppear());
	}

	@Test
	public void IconZuXUndTessa_R() {
		tacToePage.chooseSignFromComboxPlayer1("x");
		tacToePage.chooseSignFromComboxPlayer2("tessa_r");
		assertEquals("x", tacToePage.getCurrentPlayer1Sign());
		assertEquals("tessa_r", tacToePage.getCurrentPlayer2Sign());
		tacToePage.clickCell(4);
		tacToePage.clickCell(0);
	}
}