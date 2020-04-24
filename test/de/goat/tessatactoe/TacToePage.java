package de.goat.tessatactoe;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object encapsulates the Tac Toe Page
 */
public class TacToePage {

	/**
	 * The Browser which will be used.
	 */
	WebDriver driver;
	WebDriverWait wait;

	/**
	 * Combobox holds signs for player 1.
	 */
	By player1ComboBox = By.cssSelector("#player1-icon > .gwt-ListBox");

	/**
	 * Combobox holds signs for player 2.
	 */
	By player2ComboBox = By.cssSelector("#player2-icon > .gwt-ListBox");
	
	/**
	 * 
	 */
	By playerMsgWon = By.cssSelector("#playerwon > .gwt-Label");
	

	/**
	 * Default constructor.
	 * 
	 * @param driver The webbrowser will will be chosen.
	 */
	public TacToePage(final WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,30);
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
		Select element = new Select(driver.findElement(player1ComboBox));
		element.selectByValue(sign);
	}

	/**
	 * Chooses a sign from the Combobox for player 2.
	 * 
	 * @param sign The sign from the combobox which will be choosen.
	 */
	public void chooseSignFromComboxPlayer2(final String sign) {
		Select element = new Select(driver.findElement(player2ComboBox));
		element.selectByValue(sign);
	}

	/**
     * Gets the current value of combobox for player 1.
     *
     * @return current value for combobox.
     */
    public String getCurrentPlayer1Sign() {
        Select comboBox = new Select(driver.findElement(player1ComboBox));
        final String selectedComboValue = comboBox.getFirstSelectedOption().getText();
        return selectedComboValue;
    }
    
    /**
     * Gets the current value of combobox for player 2.
     *
     * @return current value for combobox.
     */
    public String getCurrentPlayer2Sign() {
        Select comboBox = new Select(driver.findElement(player2ComboBox));
        final String selectedComboValue = comboBox.getFirstSelectedOption().getText();
        return selectedComboValue;
    }
	
	/**
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
	
	/**
	 * 
	 */
	public String getPlayerWon() {
		return driver.findElement(playerMsgWon).getText();
	}
	
	public void delay() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cell-0")));
	}
	
	boolean closeButtonAppear() {
		return (driver.findElement(By.cssSelector(".gwt-Button")).isEnabled());
	}
}
