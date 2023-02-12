package com.tcs.phptravels.agent.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class AddFund {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	@FindBy(xpath = "(//a[@href=\"https://phptravels.net/account/add_funds\"])[2]")
	private WebElement addfundbtn;

	public AddFund(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;
	}

	public void addfund() throws InterruptedException {
		try {

			WebElement ofund = wait.until(ExpectedConditions.visibilityOf(addfundbtn));
			js.executeScript("arguments[0].click();", ofund);
			ofund.click();
			Reporter.log("<br>teststeppass::Sucessfully validated the AddFund page</br>");
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed validating the AddFund page</br>");
		}
	}
}
