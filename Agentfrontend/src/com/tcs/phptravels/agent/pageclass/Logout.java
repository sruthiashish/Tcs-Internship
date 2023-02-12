package com.tcs.phptravels.agent.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Logout {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@FindBy(xpath = "(//a[ @href=\"https://phptravels.net/account/logout\" ])[2]")
	private WebElement logout;

	public Logout(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;

	}

	public void logout() {
		try {
			WebElement ologout = wait.until(ExpectedConditions.visibilityOf(logout));
			js.executeScript("arguments[0].click();", ologout);

			Thread.sleep(2000);
			Reporter.log("<br>teststeppass::Sucessfully validated the logout page</br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed Validating the logout page</br>");
		}
	}
}
