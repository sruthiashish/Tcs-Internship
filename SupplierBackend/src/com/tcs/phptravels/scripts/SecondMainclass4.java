//Main class to check valid login functionality with all other test cases of stage1 with valid credentials

package com.tcs.phptravels.scripts;

import org.testng.annotations.Test;

import com.tcs.phptravels.supplier.pageclass.Dashboard;
import com.tcs.phptravels.supplier.pageclass.LoginPages;
import com.tcs.phptravels.supplier.pageclass.MyBooking;
import com.tcs.phptravels.supplier.pageclass.Tours;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SecondMainclass4 extends TestBase1 {
	
	LoginPages ologin;
	MyBooking obook;
	Dashboard oboard;
	Tours otour;

	@Test(dataProvider = "credentials")
	public void f(String username1, String password1) throws InterruptedException {
		// driver.get("https://phptravels.net/api/supplier");
		// Assert.assertEquals(driver.getTitle(), "[[[Login - PHPTRAVELS]]");
		// Reporter.log("<br>teststeppass::Sucessfully validated Title of page</br>");

	 ologin = new LoginPages(driver);
	 obook = new MyBooking(driver);
	 oboard = new Dashboard(driver);
	 otour = new Tours(driver);
		ologin.login(username1, password1);
		
		obook.setmybooking();
		driver.navigate().back();
		obook.booking();
		driver.navigate().back();
		
		oboard.viewdashboard1();
		oboard.viewdashboard2();

		
		otour.Clicktours();
	}

	@DataProvider(name = "credentials")
	public Object[][] getData() {
		return new Object[][] { { "supplier@phptravels.com", "demosupplier" } };
	}

	
}
