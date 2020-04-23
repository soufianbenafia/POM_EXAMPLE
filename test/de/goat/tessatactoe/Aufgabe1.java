package de.goat.tessatactoe;

import org.junit.Test;
import org.junit.Before;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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
		//tacToePage.delay();
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
		//tacToePage.delay();
		tacToePage.chooseSignFromComboxPlayer1("o");
		tacToePage.chooseSignFromComboxPlayer2("x");
		assertEquals("x", tacToePage.getCurrentPlayer1Sign());
		assertEquals("o", tacToePage.getCurrentPlayer2Sign());
	}

}