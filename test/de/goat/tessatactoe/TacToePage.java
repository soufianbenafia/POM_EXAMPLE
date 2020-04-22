package de.goat.tessatactoe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object encapsulates the Tac Toe Page
 */
public class TacToePage {

	/**
	 * The Browser which will be used.
	 */
	WebDriver driver;

	/**
	 * Combobox holds signs for player 1.
	 */
	By player1ComboBox = By.cssSelector("#player1-icon > .gwt-ListBox");

	/**
	 * Combobox holds signs for player 2.
	 */
	By player2ComboBox = By.cssSelector("#player2-icon > .gwt-ListBox");

	/**
	 * Default constructor.
	 * 
	 * @param driver The webbrowser will will be chosen.
	 */
	public TacToePage(final WebDriver driver) {

		this.driver = driver;

	}

	/**
	 * Clicks on specified cell number.
	 * 
	 * @param cellNumber The cell number which has to be clicked on.
	 */
	public void clickCell(final String cellNumber) {
		final String cellByNumber = "#cell-" + cellNumber + " > .button";
		driver.findElement(By.cssSelector(cellByNumber)).click();
	}

	/**
	 * Chooses a sign from the Combobox for player 1.
	 * 
	 * @param sign The sign from the combobox which will be choosen.
	 */
	public void chooseSignFromComboxPlayer1(final String sign) {
		final String signToBeChosen = "//option[. = '" + sign + "']";
		WebElement element = driver.findElement(player1ComboBox);
		element.findElement(By.xpath(signToBeChosen)).click();
	}

	/**
	 * Chooses a sign from the Combobox for player 2.
	 * 
	 * @param sign The sign from the combobox which will be choosen.
	 */
	public void chooseSignFromComboxPlayer2(final String sign) {
		final String signToBeChosen = "//option[. = '" + sign + "']";
		WebElement element = driver.findElement(player2ComboBox);
		element.findElement(By.xpath(signToBeChosen)).click();
	}

	/**
	 * Gets the score for player 1.
	 * 
	 * @return The score for player 1.
	 */
	public String getScorePlayer1() {
		return driver.findElement(By.cssSelector("#score-1 > .gwt-Label")).getText();
	}

	/**
	 * Gets the score for player 2.
	 * 
	 * @return The score for player 2.
	 */
	public String getScorePlayer2() {
		return driver.findElement(By.cssSelector("#score-2 > .gwt-Label")).getText();
	}
}
