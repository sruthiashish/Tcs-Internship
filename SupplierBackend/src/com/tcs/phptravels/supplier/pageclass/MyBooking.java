package com.tcs.phptravels.supplier.pageclass;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MyBooking {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	 
	@FindBy(xpath="//i[text()=\"event\"]")
	private WebElement pendingbookingbtn;
	@FindBy(id="booking_status")
	private WebElement bookstatus;

	@FindBy(linkText ="Bookings")
	private WebElement bookingbutton;

	
	public MyBooking(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);
		this.js= (JavascriptExecutor) driver;

	}
	
	public void setmybooking()
	{try {
		WebElement book = wait.until(ExpectedConditions.visibilityOf(pendingbookingbtn));
		js.executeScript("arguments[0].click();", book);
		Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOf(bookstatus)).click();
		Thread.sleep(3000);

		Select oselect = new Select(wait.until(ExpectedConditions.visibilityOf(bookstatus)));
		Thread.sleep(3000);

		oselect.selectByVisibleText("Confirmed");
		Thread.sleep(3000);

		Reporter.log("<b>teststeppass::Sucessfully validated the pending Booking page</br>");
		Thread.sleep(3000);
	
	}catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::Failed validating the Booking page</br>");
	}}
	public void booking()
	{try {
		WebElement books = wait.until(ExpectedConditions.visibilityOf(bookingbutton));
		js.executeScript("arguments[0].click();", books);
		Thread.sleep(3000);

		

		Reporter.log("<b>teststeppass::Sucessfully validated the Booking page</br>");
		Thread.sleep(4000);
	
	}catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::Failed validating the Booking page</br>");
	}
	
	}
}
