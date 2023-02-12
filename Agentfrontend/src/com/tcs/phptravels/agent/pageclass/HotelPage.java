package com.tcs.phptravels.agent.pageclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class HotelPage {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	@FindBy(linkText = "Hotels")
	private WebElement hotelbtn;
	@FindBy(xpath = "//div[@class=\"col-md-4\"]")
	private WebElement citybtn;
	@FindBy(xpath= "(//div[@class=\"col-md-6\"])[1]")
	private WebElement checkindate;
	@FindBy(xpath= "(//div[@class=\"col-md-6\"])[2]")
	private WebElement checkoutdate;
	@FindBy(xpath= "//div[@class=\"col-md-2\"]")
	private WebElement searchbtn;

	public HotelPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;

	}

	public void Clickhotel() {
		try {
			WebElement ohotel = wait.until(ExpectedConditions.visibilityOf(hotelbtn));
			js.executeScript("arguments[0].click();", ohotel);

			Thread.sleep(2000);
			Reporter.log("<br>teststeppass::Sucessfully validated the Hotel page</br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed Validating the Hotel page</br>");
		}
	}

	public void Searchhotel(String city, String date1, String date2) {
		try {
			WebElement City1 = wait.until(ExpectedConditions.visibilityOf(citybtn));
			wait.until(ExpectedConditions.elementToBeClickable(citybtn));
			js.executeScript("arguments[0].click();", City1);
		
			//Thread.sleep(2000);
			City1.sendKeys(city);
			//Thread.sleep(2000);
			City1.click();
			wait.until(ExpectedConditions.visibilityOf(checkindate)).sendKeys(date1);
			wait.until(ExpectedConditions.visibilityOf(checkoutdate)).sendKeys(date2);
			WebElement search=wait.until(ExpectedConditions.visibilityOf(searchbtn));
			js.executeScript("arguments[0].click();", search);
			Thread.sleep(2000);
			Reporter.log(
					"<br>teststeppass::Sucessfully validated the Search hotel by city function of Hotel page</br>");
		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed Validating the Search Hotel page by city </br>");
		}
	}
}
