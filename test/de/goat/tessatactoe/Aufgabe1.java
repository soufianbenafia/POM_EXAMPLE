package de.goat.tessatactoe;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertFalse;
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

public class Aufgabe1 {
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
	public void player1Win() {
		tacToePage.clickCell(0);
		tacToePage.clickCell(7);
		tacToePage.clickCell(1);
		tacToePage.clickCell(8);
		tacToePage.clickCell(2);
		String val = tacToePage.getPlayerWon();
		assertEquals("player1 won the match!", val);
	}

	@Test
	public void player1Und2XToO() {
		tacToePage.chooseSignFromComboxPlayer1("o");
		tacToePage.chooseSignFromComboxPlayer2("x");
		assertEquals("x", tacToePage.getCurrentPlayer1Sign());
		assertEquals("o", tacToePage.getCurrentPlayer2Sign());
	}

	@Test
	public void diagonallyWin() {
		tacToePage.clickCell(0);
		tacToePage.clickCell(1);
		tacToePage.clickCell(2);
		tacToePage.clickCell(3);
		tacToePage.clickCell(4);
		tacToePage.clickCell(5);
		tacToePage.clickCell(10);
		tacToePage.clickCell(15);
		tacToePage.clickCell(6);
		String val = tacToePage.getPlayerWon();
		assertEquals("player1 won the match!", val);
	}

	@Test
	public void notEqualIcon() {
		tacToePage.chooseSignFromComboxPlayer1("o");
		final boolean notEqual = tacToePage.getCurrentPlayer1Sign().equals(tacToePage.getCurrentPlayer2Sign());
		assertFalse("equals icons is not correct", notEqual);
	}

	/**
	 * Test if icon of players changed
	 */
	@Test
	public void testPlayerIconChanged() {
		tacToePage.chooseSignFromComboxPlayer1("o");
		tacToePage.chooseSignFromComboxPlayer2("x");
		final String player1Sign = tacToePage.getCurrentPlayer1Sign();
		final String player2Sign = tacToePage.getCurrentPlayer2Sign();
		assertEquals("o", player1Sign);
		assertEquals("x", player2Sign);
	}

	@Test(expected = NoSuchElementException.class)
	public void testLNotWin() throws InterruptedException {
		tacToePage.clickCell(0);
		tacToePage.clickCell(1);
		tacToePage.clickCell(5);
		tacToePage.clickCell(10);
		tacToePage.clickCell(15);
		tacToePage.getPlayerWon();
	}

	@Test
	public void testeAlleGewinnMoeglichkeiten() {
		// **************Horizontal***********************

		// horizontal0Spalte
		tacToePage.clickCell(0);
		tacToePage.clickCell(1);
		tacToePage.clickCell(5);
		tacToePage.clickCell(6);
		tacToePage.clickCell(10);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// horizontal1Spalte
		tacToePage.clickCell(1);
		tacToePage.clickCell(0);
		tacToePage.clickCell(6);
		tacToePage.clickCell(5);
		tacToePage.clickCell(11);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// horizontal2Spalte
		tacToePage.clickCell(2);
		tacToePage.clickCell(0);
		tacToePage.clickCell(7);
		tacToePage.clickCell(5);
		tacToePage.clickCell(12);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// horizontal3Spalte
		tacToePage.clickCell(3);
		tacToePage.clickCell(0);
		tacToePage.clickCell(8);
		tacToePage.clickCell(5);
		tacToePage.clickCell(13);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// horizontal4Spalte
		tacToePage.clickCell(4);
		tacToePage.clickCell(0);
		tacToePage.clickCell(9);
		tacToePage.clickCell(5);
		tacToePage.clickCell(14);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// **************Vertikal***********************

		// vertikalZeile0Links
		tacToePage.clickCell(0);
		tacToePage.clickCell(5);
		tacToePage.clickCell(1);
		tacToePage.clickCell(6);
		tacToePage.clickCell(2);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile0Rechts
		tacToePage.clickCell(2);
		tacToePage.clickCell(5);
		tacToePage.clickCell(3);
		tacToePage.clickCell(6);
		tacToePage.clickCell(4);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile1Links
		tacToePage.clickCell(5);
		tacToePage.clickCell(0);
		tacToePage.clickCell(6);
		tacToePage.clickCell(1);
		tacToePage.clickCell(7);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile1Rechts
		tacToePage.clickCell(7);
		tacToePage.clickCell(0);
		tacToePage.clickCell(8);
		tacToePage.clickCell(1);
		tacToePage.clickCell(9);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile2Links
		tacToePage.clickCell(10);
		tacToePage.clickCell(0);
		tacToePage.clickCell(11);
		tacToePage.clickCell(1);
		tacToePage.clickCell(12);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile2Links
		tacToePage.clickCell(10);
		tacToePage.clickCell(0);
		tacToePage.clickCell(11);
		tacToePage.clickCell(1);
		tacToePage.clickCell(12);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile2Rechts
		tacToePage.clickCell(12);
		tacToePage.clickCell(0);
		tacToePage.clickCell(13);
		tacToePage.clickCell(1);
		tacToePage.clickCell(14);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile3Links
		tacToePage.clickCell(15);
		tacToePage.clickCell(0);
		tacToePage.clickCell(16);
		tacToePage.clickCell(1);
		tacToePage.clickCell(18);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// vertikalZeile3Rechts
		tacToePage.clickCell(17);
		tacToePage.clickCell(0);
		tacToePage.clickCell(18);
		tacToePage.clickCell(5);
		tacToePage.clickCell(19);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// **************diagonal***********************

		// diagonal0
		tacToePage.clickCell(10);
		tacToePage.clickCell(0);
		tacToePage.clickCell(6);
		tacToePage.clickCell(5);
		tacToePage.clickCell(2);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// diagonal1
		tacToePage.clickCell(15);
		tacToePage.clickCell(0);
		tacToePage.clickCell(11);
		tacToePage.clickCell(6);
		tacToePage.clickCell(7);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// diagonal2
		tacToePage.clickCell(11);
		tacToePage.clickCell(0);
		tacToePage.clickCell(7);
		tacToePage.clickCell(6);
		tacToePage.clickCell(3);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// diagonal3
		tacToePage.clickCell(16);
		tacToePage.clickCell(0);
		tacToePage.clickCell(12);
		tacToePage.clickCell(6);
		tacToePage.clickCell(8);
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// diagonal4
		tacToePage.clickCell(16);
		tacToePage.clickCell(0);
		tacToePage.clickCell(12);
		tacToePage.clickCell(6);
		tacToePage.clickCell(8);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// diagonal5
		tacToePage.clickCell(12);
		tacToePage.clickCell(0);
		tacToePage.clickCell(8);
		tacToePage.clickCell(6);
		tacToePage.clickCell(9);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// **************PunkteNichtVerbunden***********************
		// PunkteNichtVerbunden0
		tacToePage.clickCell(0);
		tacToePage.clickCell(1);
		tacToePage.clickCell(10);
		tacToePage.clickCell(6);
		tacToePage.clickCell(15);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// PunkteNichtVerbunden1
		tacToePage.clickCell(1);
		tacToePage.clickCell(7);
		tacToePage.clickCell(6);
		tacToePage.clickCell(8);
		tacToePage.clickCell(16);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		// PunkteNichtVerbunden2
		tacToePage.clickCell(15);
		tacToePage.clickCell(7);
		tacToePage.clickCell(16);
		tacToePage.clickCell(8);
		tacToePage.clickCell(18);
		assertTrue(tacToePage.closeButtonAppear());
		driver.findElement(By.cssSelector(".gwt-Button")).click();
	}

	@Test
	public void felderKlicken() {
		// 1 mal markieren
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

		// mehrmals markieren
		for (int i = 0; i <= 20; i++) {
			tacToePage.clickCell(9);
		}

		for (int i = 0; i <= 20; i++) {
			tacToePage.clickCell(4);
		}

		for (int i = 0; i <= 20; i++) {
			tacToePage.clickCell(5);
		}

		for (int i = 0; i <= 20; i++) {
			tacToePage.clickCell(2);
		}
	}
}
