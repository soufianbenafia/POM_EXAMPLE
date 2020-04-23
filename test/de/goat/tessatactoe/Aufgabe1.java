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
	
	
	
	//Faissal
	
	@Test
	public void testcase7() {
		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		driver.manage().window().setSize(new Dimension(1366, 768));


		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cell-0 > .button")));
		//**************Horizontal***********************	

		//horizontal0Spalte
		
		markfield(0, 1, driver);
		markfield(5, 6, driver);
		markfield(10, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();


		//horizontal1Spalte
		markfield(1, 0, driver);
		markfield(6, 5, driver);
		markfield(11, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();


		//horizontal2Spalte
		markfield(2, 0, driver);
		markfield(7, 5, driver);
		markfield(12, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();


		//horizontal3Spalte
		markfield(3, 0, driver);
		markfield(8, 5, driver);
		markfield(13, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//horizontal4Spalte
		markfield(4, 0, driver);
		markfield(9, 5, driver);
		markfield(14, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//**************Vertikal***********************	

		//vertikalZeile0Links
		markfield(0, 5, driver);
		markfield(1, 6, driver);
		markfield(2, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile0Rechts
		markfield(2, 5, driver);
		markfield(3, 6, driver);
		markfield(4, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile1Links
		markfield(5, 0, driver);
		markfield(6, 1, driver);
		markfield(7, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile1Rechts
		markfield(7, 0, driver);
		markfield(8, 1, driver);
		markfield(9, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile2Links
		markfield(10, 0, driver);
		markfield(11, 1, driver);
		markfield(12, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile2Links
		markfield(10, 0, driver);
		markfield(11, 1, driver);
		markfield(12, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile2Rechts
		markfield(12, 0, driver);
		markfield(13, 1, driver);
		markfield(14, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile3Links
		markfield(15, 0, driver);
		markfield(16, 1, driver);
		markfield(17, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//vertikalZeile3Rechts
		markfield(17, 0, driver);
		markfield(18, 5, driver);
		markfield(19, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//**************diagonal***********************	

		//diagonal0
		markfield(10, 0, driver);
		markfield(6, 5, driver);
		markfield(2, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//diagonal1
		markfield(15, 0, driver);
		markfield(11, 6, driver);
		markfield(7, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//diagonal2
		markfield(11, 0, driver);
		markfield(7, 6, driver);
		markfield(3, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//diagonal3
		markfield(16, 0, driver);
		markfield(12, 6, driver);
		markfield(8, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();


		//diagonal4
		markfield(16, 0, driver);
		markfield(12, 6, driver);
		markfield(8, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//diagonal5
		markfield(12, 0, driver);
		markfield(8, 6, driver);
		markfield(9, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//**************PunkteNichtVerbunden***********************	

		//PunkteNichtVerbunden0
		markfield(0, 1, driver);
		markfield(10, 6, driver);
		markfield(15, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//PunkteNichtVerbunden1
		markfield(1, 7, driver);
		markfield(6, 8, driver);
		markfield(16, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		//PunkteNichtVerbunden2
		markfield(15, 7, driver);
		markfield(16, 8, driver);
		markfield(18, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();



	}

	//@Test
	public void testCase8() {
		System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		driver.manage().window().setSize(new Dimension(1280, 680));

		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cell-0 > .button")));

		//1 mal markieren
		markfield(0, 1, driver);
		markfield(6, 5, driver);
		markfield(10, 11, driver);
		markfield(16, 15, driver);
		markfield(7, 2, driver);
		markfield(17, 12, driver);
		markfield(3, 8, driver);
		markfield(13, 18, driver);
		markfield(4, 9, driver);
		markfield(14, 9, driver);

		//reset
		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		driver.manage().window().setSize(new Dimension(1280, 680));

		WebElement firstResult1	 = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cell-0 > .button")));

		//2 mal markieren
		markfield(0, 1, driver);
		markfield(0, 1, driver);
		markfield(6, 5, driver);
		markfield(6, 5, driver);
		markfield(10, 11, driver);
		markfield(10, 11, driver);
		markfield(16, 15, driver);
		markfield(16, 15, driver);
		markfield(7, 2, driver);
		markfield(7, 2, driver);
		markfield(17, 12, driver);
		markfield(17, 12, driver);
		markfield(3, 8, driver);
		markfield(3, 8, driver);
		markfield(13, 18, driver);
		markfield(13, 18, driver);
		markfield(4, 9, driver);
		markfield(4, 9, driver);
		markfield(14, 9, driver);
		markfield(14, 9, driver);

		driver.close();
	}


	//@Test
	public void test() {



		System.setProperty("webdriver.chrome.driver", "C:/WebDriver/bin/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		driver.manage().window().setSize(new Dimension(1280, 680));

		markfield(0, 1, driver);
		markfield(5, 1, driver);
		markfield(10, noField
				, driver);
		assertTrue(driver.findElement(By.linkText("The Game ended:\r\n" + 
				"player1 won the match!")).isDisplayed());
	}



	//************************hilfsmethoden**********************************

	public void markfield(int fieldForP1, int fieldFor2,WebDriver driver2) {
		switch(fieldForP1) {

		case 0:  driver2.findElement(By.cssSelector("#cell-0 > .button")).click();break;
		case 1:  driver2.findElement(By.cssSelector("#cell-1 > .button")).click();break;
		case 2:  driver2.findElement(By.cssSelector("#cell-2 > .button")).click();break;
		case 3:  driver2.findElement(By.cssSelector("#cell-3 > .button")).click();break;
		case 4:  driver2.findElement(By.cssSelector("#cell-4 > .button")).click();break;
		case 5:  driver2.findElement(By.cssSelector("#cell-5 > .button")).click();break;
		case 6:  driver2.findElement(By.cssSelector("#cell-6 > .button")).click();break;
		case 7:  driver2.findElement(By.cssSelector("#cell-7 > .button")).click();break;
		case 8:  driver2.findElement(By.cssSelector("#cell-8 > .button")).click();break;
		case 9:  driver2.findElement(By.cssSelector("#cell-9 > .button")).click();break;
		case 10: driver2.findElement(By.cssSelector("#cell-10 > .button")).click();break;
		case 11: driver2.findElement(By.cssSelector("#cell-11 > .button")).click();break;
		case 12: driver2.findElement(By.cssSelector("#cell-12 > .button")).click();break;
		case 13: driver2.findElement(By.cssSelector("#cell-13 > .button")).click();break;
		case 14: driver2.findElement(By.cssSelector("#cell-14 > .button")).click();break;
		case 15: driver2.findElement(By.cssSelector("#cell-15 > .button")).click();break;
		case 16: driver2.findElement(By.cssSelector("#cell-16 > .button")).click();break;
		case 17: driver2.findElement(By.cssSelector("#cell-17 > .button")).click();break;
		case 18: driver2.findElement(By.cssSelector("#cell-18 > .button")).click();break;
		case 19: driver2.findElement(By.cssSelector("#cell-19 > .button")).click();break;
		default: break;
		}

		switch(fieldFor2) {
		case 0:  driver2.findElement(By.cssSelector("#cell-0 > .button")).click();break;
		case 1:  driver2.findElement(By.cssSelector("#cell-1 > .button")).click();break;
		case 2:  driver2.findElement(By.cssSelector("#cell-2 > .button")).click();break;
		case 3:  driver2.findElement(By.cssSelector("#cell-3 > .button")).click();break;
		case 4:  driver2.findElement(By.cssSelector("#cell-4 > .button")).click();break;
		case 5:  driver2.findElement(By.cssSelector("#cell-5 > .button")).click();break;
		case 6:  driver2.findElement(By.cssSelector("#cell-6 > .button")).click();break;
		case 7:  driver2.findElement(By.cssSelector("#cell-7 > .button")).click();break;
		case 8:  driver2.findElement(By.cssSelector("#cell-8 > .button")).click();break;
		case 9:  driver2.findElement(By.cssSelector("#cell-9 > .button")).click();break;
		case 10: driver2.findElement(By.cssSelector("#cell-10 > .button")).click();break;
		case 11: driver2.findElement(By.cssSelector("#cell-11 > .button")).click();break;
		case 12: driver2.findElement(By.cssSelector("#cell-12 > .button")).click();break;
		case 13: driver2.findElement(By.cssSelector("#cell-13 > .button")).click();break;
		case 14: driver2.findElement(By.cssSelector("#cell-14 > .button")).click();break;
		case 15: driver2.findElement(By.cssSelector("#cell-15 > .button")).click();break;
		case 16: driver2.findElement(By.cssSelector("#cell-16 > .button")).click();break;
		case 17: driver2.findElement(By.cssSelector("#cell-17 > .button")).click();break;
		case 18: driver2.findElement(By.cssSelector("#cell-18 > .button")).click();break;
		case 19: driver2.findElement(By.cssSelector("#cell-19 > .button")).click();break;
		default: break;
		}
	}






}