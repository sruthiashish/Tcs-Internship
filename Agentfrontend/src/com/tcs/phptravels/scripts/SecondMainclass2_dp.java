//Main class to check valid login functionality with all other test cases of stage1 with valid credentials

package com.tcs.phptravels.scripts;

import org.testng.annotations.Test;

import com.tcs.phptravels.agent.pageclass.AddFund;
import com.tcs.phptravels.agent.pageclass.Blogs;
import com.tcs.phptravels.agent.pageclass.Flights;
import com.tcs.phptravels.agent.pageclass.Homepage;
import com.tcs.phptravels.agent.pageclass.HotelPage;
import com.tcs.phptravels.agent.pageclass.LoginPages;
import com.tcs.phptravels.agent.pageclass.Logout;
import com.tcs.phptravels.agent.pageclass.MyBooking;
import com.tcs.phptravels.agent.pageclass.MyProfile;
import com.tcs.phptravels.agent.pageclass.Offers;
import com.tcs.phptravels.agent.pageclass.Tours;
import com.tcs.phptravels.agent.pageclass.Visa;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

public class SecondMainclass2_dp {
	WebDriver driver;
	WebDriverWait wait;

	@Test(dataProvider = "credentials")
	public void f(String username1, String password1) throws InterruptedException {

		driver.get("https://phptravels.net/login");
		// Assert.assertEquals(driver.getTitle(), "[[[Login - PHPTRAVELS]]");
		// Reporter.log("<br>teststeppass::Sucessfully validated Title of page</br>");

		LoginPages ologin = new LoginPages(driver);
		ologin.login(username1, password1);
		MyBooking obook = new MyBooking(driver);
		obook.setmybooking();
		AddFund ofund = new AddFund(driver);
		ofund.addfund();
		MyProfile oprofile = new MyProfile(driver);
		oprofile.adddprofile();
		Logout ologout = new Logout(driver);
		ologout.logout();

		/*
		 * ologin.login(username1, password1); Homepage ohome = new Homepage(driver);
		 * ohome.Clickhome(); HotelPage ohotel=new HotelPage(driver);
		 * ohotel.Clickhotel(); //ohotel.Searchhotel(); Tours otour= new Tours(driver);
		 * otour.Clicktours(); Flights oflight= new Flights(driver); oflight.Clickbtn();
		 * Visa ovisa= new Visa(driver); ovisa.ClickVisa(); Blogs oblogs= new
		 * Blogs(driver); oblogs.Clickblog(); Offers oofers= new Offers(driver);
		 * oofers.Clickoffers();
		 */

	}

	@DataProvider(name = "credentials")
	public Object[][] getData() {
		return new Object[][] { { "agent@phptravels.com", "demoagent" } };
	}

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "F:\\AutomationUtils\\Drivers\\geckodriver.exe");

		driver = new FirefoxDriver();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
