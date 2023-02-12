package com.tcs.phptravels.agent.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MyProfile {
	WebDriver driver;
	 WebDriverWait wait;
		JavascriptExecutor js;

	@FindBy(xpath ="(//a[@href=\"https://phptravels.net/account/profile\"])[2]")
	private WebElement myprofilebtn;
	
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
	WebElement oprofile=	wait.until(ExpectedConditions.visibilityOf(myprofilebtn));
		js.executeScript("arguments[0].click();", oprofile);

		Thread.sleep(3000);
		Reporter.log("<br>teststeppass::Sucessfully validated the My Profile page</br>");

	}catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::Failed validating the My Profile page</br>");
	}
}}
