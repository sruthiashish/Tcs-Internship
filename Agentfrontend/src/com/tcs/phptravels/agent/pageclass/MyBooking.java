package com.tcs.phptravels.agent.pageclass;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MyBooking {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	 
	@FindBy(xpath="(//li[@class=\"page-active\"]/following-sibling::li/a)[1]")
	private WebElement Mybookingbtn;
	
	
	
	public MyBooking(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);
		this.js= (JavascriptExecutor) driver;

	}
	
	public void setmybooking()
	{try {
		WebElement book = wait.until(ExpectedConditions.visibilityOf(Mybookingbtn));
		js.executeScript("arguments[0].click();", book);
		Reporter.log("<br>teststeppass::Sucessfully validated the Booking page</br>");
		Thread.sleep(3000);
	
	}catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::Failed validating the Booking page</br>");
	}}
	

}
