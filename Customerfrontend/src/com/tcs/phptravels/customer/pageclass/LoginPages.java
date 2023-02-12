package com.tcs.phptravels.customer.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPages {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(name="email")
	private WebElement username;
	@FindBy(name="password")
	private WebElement password;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement login;
	
	public LoginPages(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait= new WebDriverWait(driver, 30);
	}
	public void  login(String username1,String password1) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(username)).sendKeys(username1);		
		wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(password1);		
		wait.until(ExpectedConditions.visibilityOf(login)).click();		
		Thread.sleep(2000);

	
	}


}
