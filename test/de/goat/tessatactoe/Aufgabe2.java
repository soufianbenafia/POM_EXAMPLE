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
		// tacToePage.delay();
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
		// tacToePage.delay();
		tacToePage.clickCell("2");
		tacToePage.clickCell("5");
		tacToePage.clickCell("8");
		tacToePage.clickCell("10");
		tacToePage.clickCell("14");
		tacToePage.clickCell("10");
		tacToePage.getPlayerWon();
	}

	@Test
	public void playerBiuld_V() throws InterruptedException {
		// tacToePage.delay();
		tacToePage.clickCell("0");
		tacToePage.clickCell("1");
		tacToePage.clickCell("6");
		tacToePage.clickCell("7");
		tacToePage.clickCell("2");

		String val1 = tacToePage.getScorePlayer1();
		String val2 = tacToePage.getScorePlayer2();
		assertEquals("0", val1);
		assertEquals("0", val2);
	}

	@Test
	public void inpossibleWin() throws InterruptedException {
		// tacToePage.delay();
		tacToePage.clickCell("0");
		tacToePage.clickCell("1");
		tacToePage.clickCell("2");
		tacToePage.clickCell("3");
		tacToePage.clickCell("4");
		tacToePage.clickCell("6");
		tacToePage.clickCell("5");
		tacToePage.clickCell("8");
		tacToePage.clickCell("7");
		tacToePage.clickCell("10");
		tacToePage.clickCell("9");
		tacToePage.clickCell("12");
		tacToePage.clickCell("11");
		tacToePage.clickCell("14");
		tacToePage.clickCell("13");
		tacToePage.clickCell("15");
		tacToePage.clickCell("16");
		tacToePage.clickCell("17");
		tacToePage.clickCell("18");
		String val1 = tacToePage.getScorePlayer1();
		String val2 = tacToePage.getScorePlayer2();
		assertEquals("0", val1);
		assertEquals("0", val2);
	}
	
	//Faissal
		@Test
	public void bug6() {


		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		driver.manage().window().setSize(new Dimension(1366, 768));

		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cell-7 > .button")));

		int i = 30;
		while(i > 0) {

			driver.findElement(By.cssSelector("#cell-7 > .button")).click();
			i--;
		}
	}

	//@Test
	public void bug10() {

		//horizontal4Spalte


		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		driver.manage().window().setSize(new Dimension(1366, 768));

		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cell-7 > .button")));

		markfield(4, 0, driver);
		markfield(9, 5, driver);
		markfield(14, noField, driver);		
		assertTrue(driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
		driver.findElement(By.cssSelector(".gwt-Button")).click();

		driver.close();
	}


	//@Test
	public void bug5() {
		
		driver.get("http://127.0.0.1:8888/TeSSA_Tac_Toe_GWT.html");
		driver.manage().window().setSize(new Dimension(1366, 768));

		driver.findElement(By.cssSelector("#player2-icon > .gwt-ListBox")).click();
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement dropdown = driver.findElement(By.cssSelector("#player2-icon > .gwt-ListBox"));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dropdown.findElement(By.xpath("//option[. = 'tessa_r']")).click();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		driver.findElement(By.cssSelector("#cell-0 > .button")).click();
		driver.findElement(By.cssSelector("#cell-1 > .button")).click();

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