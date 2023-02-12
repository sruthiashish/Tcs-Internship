package com.tcs.phptravels.supplier.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Tours {
	WebDriver driver;
	 WebDriverWait wait;
		JavascriptExecutor js;

	@FindBy(xpath = "//a[@aria-controls='toursmodule']")
	private WebElement toursbtn;
	
	public Tours(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);
		this.js= (JavascriptExecutor) driver;

	}
	public void Clicktours()
	{try {
		
		WebElement otour = wait.until(ExpectedConditions.visibilityOf(toursbtn));
		js.executeScript("arguments[0].click();", otour);
	
		Thread.sleep(3000);
		Reporter.log("<br>teststeppass::Sucessfully validated the Tours page</br>");
	}catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::Failed Validating the Tours page</br>");
	}}
}
