package com.tcs.phptravels.customer.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	WebDriver driver;
	 WebDriverWait wait;
	@FindBy(xpath ="(//li[@class=\"user_wallet \"]/following-sibling::li/a)[2]")
	private WebElement logout;
	
	public Logout(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);

	}
	public void logout()
	{try {
		wait.until(ExpectedConditions.visibilityOf(logout)).click();
	}catch (Exception e) {
		// TODO: handle exception
	}}
}
