package com.tcs.phptravels.supplier.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Dashboard {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	 
	@FindBy(xpath="//div[text()='Sales overview & summary']")
	private WebElement dashboardview;
	
	@FindBy(xpath= "//h2 [text()='Revenue Breakdown 2023']")
	private WebElement dashboardview2;


	
	public Dashboard(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		this.wait =new WebDriverWait(driver,30);
		this.js= (JavascriptExecutor) driver;

	}
	public void viewdashboard1()
	{try {
		String text =wait.until(ExpectedConditions.visibilityOf(dashboardview)).getText();
		System.out.println(text);
		
		Assert.assertEquals(text, "Sales overview & summary");
		Reporter.log("<br>teststeppass::Text validated successfully</br>");
	}catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
		Reporter.log("<br>teststepfail::Failed validating text</br>");

	}}
	public void viewdashboard2()
	{try {
		String text2 =wait.until(ExpectedConditions.visibilityOf(dashboardview2)).getText();
		System.out.println(text2);
		
		Assert.assertEquals(text2, "Revenue Breakdown 2023");
		Reporter.log("<br>teststeppass::Text validated successfully</br>");

	}catch (Exception e) {
		e.printStackTrace();// TODO: handle exception
		Reporter.log("<br>teststepfail::Failed validating text</br>");

	}
}}
