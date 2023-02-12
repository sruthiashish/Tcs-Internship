
//Test Script to check home page functionality and updation of USD To INR for the account
package com.tcs.phptravels.agent.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Homepage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	Actions act;
	@FindBy(xpath = "//div[@class='logo']/a")
	private WebElement homebtn;
	@FindBy(id = "currency")
	private WebElement currencydropdownusd;
	@FindBy(xpath = "//ul[@class=\"dropdown-menu show\"] /li[7]")
	private WebElement currencydropdownINR;

	public Homepage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
		this.act = new Actions(driver);
	}

	public void Clickhome() {
		try {
			wait.until(ExpectedConditions.visibilityOf(homebtn)).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(currencydropdownusd)).click();
			Thread.sleep(2000);
			// WebElement dropdown=
			WebElement target = wait.until(ExpectedConditions.visibilityOf(currencydropdownINR));

			act.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.DOWN))
					.click(target).perform();

			/*
			 * js.executeScript("arguments[0].ScrollIntoView();", dropdown);
			 * dropdown.click();
			 */
			Thread.sleep(2000);
			Reporter.log("<br>teststeppass::Sucessfully validated the Home page</br>");

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed Validating the Home page</br>");
		}
	}
}
