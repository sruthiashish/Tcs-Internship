package com.tcs.phptravels.customer.pageclass;

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

public class MyBooking {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	 
	@FindBy(xpath="(//li[@class=\"page-active\"]/following-sibling::li/a)[1]")
	private WebElement Mybookingbtn;
	@FindBy(xpath="(//a[@target=\"_blank\"])[1]")
	private WebElement viewvoucher;
	
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
		Thread.sleep(3000);
	
	}catch (Exception e) {
		// TODO: handle exception
	}}
	
	public void viewmybooking() throws InterruptedException
	{try {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		WebElement oview = wait.until(ExpectedConditions.visibilityOf(viewvoucher));
		js.executeScript("arguments[0].click();", oview);
		Thread.sleep(3000);
		//driver.switchTo().window(tabs.get(1));
		
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(3000);
		
	
	}catch (Exception e) {
		// TODO: handle exception
	}}
}
