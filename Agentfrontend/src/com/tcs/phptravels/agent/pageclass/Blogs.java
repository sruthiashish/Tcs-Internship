package com.tcs.phptravels.agent.pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Blogs {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;

	@FindBy(linkText = "Blog")
	private WebElement blogbtn;

	public Blogs(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;

	}

	public void Clickblog() {
		try {
			WebElement blog = wait.until(ExpectedConditions.visibilityOf(blogbtn));
			js.executeScript("arguments[0].click();", blog);

			Thread.sleep(2000);
			Reporter.log("<br>teststeppass::Sucessfully validated the Blog page</br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed Validating the Blog page</br>");
		}
	}

}
