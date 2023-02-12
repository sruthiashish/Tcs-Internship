package com.tcs.phptravels.supplier.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class LoginPages {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(name = "email")
	private WebElement username;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath = "//span[text()=\"Login\"]")
	private WebElement login;
	
	public LoginPages(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait= new WebDriverWait(driver, 30);
	}
	public void  login(String username1,String password1) throws InterruptedException
	{try {
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(username1);		
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(password1);		
		wait.until(ExpectedConditions.visibilityOf(login)).click();		
		Thread.sleep(3000);
		Reporter.log("<br>teststeppass::Sucessfully validated the login page</br>");
	}
	catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::failed validating the login page</br>");
	
	}
	}
	
	

}
