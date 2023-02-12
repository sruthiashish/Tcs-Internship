package com.tcs.phptravels.agent.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Visa {
	WebDriver driver;
	 WebDriverWait wait;
		JavascriptExecutor js;

	@FindBy(xpath = "//a[@title='visa']")
	private WebElement visabtn;
	
	public Visa(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);
		this.js= (JavascriptExecutor) driver;

	}
	public void ClickVisa()
	{try {
		WebElement visabtnclick= wait.until(ExpectedConditions.visibilityOf(visabtn));
		js.executeScript("arguments[0].click();", visabtnclick);

		Thread.sleep(2000);
		Reporter.log("<br>teststeppass::Sucessfully validated the Visa page</br>");
	}catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::Failed Validating the Visa page</br>");
	}}
}
