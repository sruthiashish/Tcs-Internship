
//Main class to check login functionality of Phptravels with valid and invalid test cases

package com.tcs.phptravels.scripts;

import org.testng.annotations.Test;

import com.tcs.phptravels.admin.pageclass.LoginPages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class Mainclass3 {
	WebDriver driver;
JavascriptExecutor js;
	@Test(dataProvider = "credentials")
	public void verifyloginvalidation(String scenario, String username, String password) throws InterruptedException {

		driver.get("https://phptravels.net/api/admin");
		// Assert.assertEquals(driver.getTitle(), "Login - PHPTRAVELS");

		LoginPages ologin = new LoginPages(driver);
		ologin.login(username, password);
		if (scenario.equals("bothcorrect")) {
			WebElement account = driver.findElement(By.xpath("(//i[text()='person'])[1]"));
			this.js= (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", account);

			Assert.assertTrue(account.isDisplayed());
			Reporter.log("<br>teststeppass::Login Successful</br>");

		} else if (scenario.equals("bothwrong")) {
			String errormessage = driver.findElement(By.cssSelector("div.message")).getText();
			Assert.assertEquals(errormessage, "WrongCredential Try again");
			Reporter.log("<br>teststeppass::Login Unsuccessful</br>");
		} else if (scenario.equals("correctusername")) {
			String errormessage = driver.findElement(By.cssSelector("div.message")).getText();
			Assert.assertEquals(errormessage, "WrongCredential Try again");
			Reporter.log("<br>teststeppass::Login Unsuccessful</br>");
		} else {
			String errormessage = driver.findElement(By.cssSelector("div.message")).getText();
			Assert.assertEquals(errormessage, "WrongCredential Try again");
			Reporter.log("<br>teststeppass::Login Unsuccessful</br>");
		}
	}

	@DataProvider(name = "credentials")
	public Object[][] getData() {
		return new Object[][] { 
				{ "bothwrong", "abc@gmail.com", "def" }, { "correctusername", "admin@phptravels.com", "deff" },
				{ "correctpassword", "abcd@yahoo.com", "demoadmin" }, { "bothcorrect", "admin@phptravels.com", "demoadmin" }

		};
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "F:\\AutomationUtils\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "F:\\AutomationUtils\\Drivers\\geckodriver.exe");
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.close();

	}

}
