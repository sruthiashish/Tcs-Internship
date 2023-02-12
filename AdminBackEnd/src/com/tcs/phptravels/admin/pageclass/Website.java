package com.tcs.phptravels.admin.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Website {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(xpath="//a[text()='Website']")
	private WebElement websitebtn;
	
	public Website(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait= new WebDriverWait(driver, 30);
	}
	public void  clickwebsite() throws InterruptedException
	{try {
		wait.until(ExpectedConditions.visibilityOf(websitebtn)).click();		
		
		Thread.sleep(2000);
		Reporter.log("<br>teststeppass::Sucessfully validated the website page</br>");
	}
	catch (Exception e) {
		e.printStackTrace();
		Reporter.log("<br>teststepfail::failed validating the website page</br>");
	
	}
	}
}
