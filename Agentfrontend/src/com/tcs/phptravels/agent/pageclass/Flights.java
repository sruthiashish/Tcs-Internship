package com.tcs.phptravels.agent.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Flights {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@FindBy(xpath = "//a[@title='flights']")
	private WebElement flightbtn;

	public Flights(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;

	}

	public void Clickbtn() {
		try {
			WebElement flightbtnclick = wait.until(ExpectedConditions.visibilityOf(flightbtn));
			js.executeScript("arguments[0].click();", flightbtnclick);
			Thread.sleep(3000);
			Reporter.log("<br>teststeppass::Sucessfully validated the Flights page</br>");

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed Validating the Flights page</br>");
		}
	}
}
