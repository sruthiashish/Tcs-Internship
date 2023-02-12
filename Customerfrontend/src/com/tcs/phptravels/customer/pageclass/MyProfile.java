package com.tcs.phptravels.customer.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfile {
	WebDriver driver;
	 WebDriverWait wait;
	 JavascriptExecutor js;
	@FindBy(xpath ="(//li[@class=\"user_wallet \"]/following-sibling::li/a)[1]")
	private WebElement myprofilebtn;
	@FindBy(name ="address2")
	private WebElement address;
	@FindBy(xpath ="//button[@type='submit']")
	private WebElement updateaddress;
	public MyProfile(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);
		this.js= (JavascriptExecutor) driver;

	}
	public void adddprofile()
	{
		try {		

		WebElement opay=wait.until(ExpectedConditions.visibilityOf(myprofilebtn));
		
		js.executeScript("arguments[0].click();", opay);
        Thread.sleep(3000);

	}catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}
	
	public void updateprofile(String address1)
	{
		try {		

		wait.until(ExpectedConditions.visibilityOf(address)).clear();
		address.sendKeys(address1);
		Thread.sleep(3000);
		
	    WebElement oupdate=	wait.until(ExpectedConditions.visibilityOf(updateaddress));
		js.executeScript("arguments[0].click();", oupdate);

	}catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
	}
}}
