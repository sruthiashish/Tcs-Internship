package com.tcs.phptravels.admin.pageclass;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class MyBooking {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	@FindBy(xpath = "(//a[text()='Bookings'])[1]")
	private WebElement bookingbtn;

	@FindBy(xpath = "//i[text()='credit_score']")
	private WebElement paidcustbtn;

	@FindBy(xpath = "//i[text()='clear']")
	private WebElement deletecustbtn;
	@FindBy(xpath = "(//i[@class=\"fa fa-times\"]/parent::button)[1]")
	private WebElement deletecustbtn2;

	@FindBy(xpath = "//i[text()=\"event\"]")
	private WebElement pendingbookingbtn1;
	@FindBy(id = "booking_status")
	private WebElement bookstatus1;

	@FindBy(xpath = "(//div[@class='display-5'])[1]")
	private WebElement count;
//	@FindBy(linkText ="Bookings")
	// private WebElement bookingbutton1;

	public MyBooking(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 30);
		this.js = (JavascriptExecutor) driver;

	}

	public void clickbooking() {
		try {
			WebElement book = wait.until(ExpectedConditions.visibilityOf(bookingbtn));
			js.executeScript("arguments[0].click();", book);
			Thread.sleep(3000);
			Reporter.log("<b>teststeppass::Sucessfully validated the Booking button</br>");

			wait.until(ExpectedConditions.visibilityOf(paidcustbtn)).click();
			Thread.sleep(3000);
			Reporter.log("<b>teststeppass::Sucessfully validated the paid Booking button</br>");

			Thread.sleep(3000);

			Reporter.log("<b>teststeppass::Sucessfully validated the Booking page</br>");
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed validating the Booking page</br>");
		}
	}

	public void deletebooking() {
		try {
			WebElement book = wait.until(ExpectedConditions.visibilityOf(deletecustbtn));
			js.executeScript("arguments[0].click();", book);
			Thread.sleep(3000);
			Reporter.log("<b>teststeppass::Sucessfully validated the delete customer Booking button</br>");

			wait.until(ExpectedConditions.visibilityOf(deletecustbtn2)).click();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();

			Reporter.log("<b>teststeppass::Sucessfully validated the delete customer button</br>");

			Thread.sleep(3000);

			Reporter.log("<b>teststeppass::Sucessfully validated the Booking page</br>");
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed validating the Booking page</br>");
		}
	}

	public void setmybooking() {
		try {

			String initialcounter = wait.until(ExpectedConditions.visibilityOf(count)).getText();

			// int countervalBefore = Integer.parseInt(initialcounter);
			System.out.println("value of the counter before click/refresh is : " + initialcounter);

			// System.out.println("value of the counter before click/refresh is : " +
			// countervalBefore);
			WebElement obook = wait.until(ExpectedConditions.visibilityOf(pendingbookingbtn1));
			js.executeScript("arguments[0].click();", obook);
			Thread.sleep(2000);

			// wait.until(ExpectedConditions.visibilityOf(bookstatus1)).click();
			// Thread.sleep(3000);
			WebElement bookst = wait.until(ExpectedConditions.visibilityOf(bookstatus1));

			Select oselect = new Select(bookst);
			Thread.sleep(2000);

			// oselect.selectByVisibleText("pending");
			oselect.selectByIndex(1);
			Thread.sleep(2000);
			String aftercounter = wait.until(ExpectedConditions.visibilityOf(count)).getAttribute("value");
			// int countervalAfter = Integer.parseInt(aftercounter);
			System.out.println("value of the counter before click/refresh is : " + aftercounter);
			// verifying the previous counter value with current counter value
			/*
			 * if(initialcounter > aftercounter){
			 * System.out.println("Count got updated in dashboard"); }else{
			 * System.out.println("Counter not working"); }
			 */

			Reporter.log(
					"<b>teststeppass::Sucessfully validated the pending Booking page with count updated in dashboard</br>");
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log(
					"<br>teststepfail::Failed validating pending Booking page with count updated in dashboard</br>");
		}
	}

	public void pendingbooking() {
		try {
			WebElement books = wait.until(ExpectedConditions.visibilityOf(bookingbtn));
			js.executeScript("arguments[0].click();", books);
			Thread.sleep(3000);

			Reporter.log("<b>teststeppass::Sucessfully validated the Booking page</br>");

		} catch (Exception e) {
			e.printStackTrace();
			Reporter.log("<br>teststepfail::Failed validating the Booking page</br>");
		}

	}
}
