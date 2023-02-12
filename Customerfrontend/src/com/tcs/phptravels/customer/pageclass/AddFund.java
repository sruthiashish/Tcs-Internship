package com.tcs.phptravels.customer.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFund {
	WebDriver driver;
	 WebDriverWait wait;
	 JavascriptExecutor js;
	@FindBy(xpath ="//li[@class=\"user_wallet \"]")
	private WebElement addfundbtn;
	@FindBy(id ="gateway_paypal")
	private WebElement paypal;
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement paynowbtn;
	public AddFund(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);
		this.js= (JavascriptExecutor) driver;
	}
	public void addfund() throws InterruptedException
	{try {
		
	
		WebElement ofund=wait.until(ExpectedConditions.visibilityOf(addfundbtn));
		js.executeScript("arguments[0].scrollIntoView;", ofund);
		ofund.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(paypal)).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(paynowbtn)).click();
		//Thread.sleep(2000);
		//driver.navigate().back();
		
	}catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}}
