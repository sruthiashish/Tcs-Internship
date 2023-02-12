//Main class to check valid login functionality with all other test cases of stage1 with valid credentials

package com.tcs.phptravels.scripts;
import org.testng.annotations.Test;

import com.tcs.phptravels.customer.pageclass.AddFund;
import com.tcs.phptravels.customer.pageclass.LoginPages;
import com.tcs.phptravels.customer.pageclass.Logout;
import com.tcs.phptravels.customer.pageclass.MyBooking;
import com.tcs.phptravels.customer.pageclass.MyProfile;
import com.tcs.utilities.ExcelUtility;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class SecondMainclass_dp extends TestBase1 {

	
	LoginPages ologin;
	MyBooking obook;
	AddFund ofund;
//	MyProfile oprofile;
	Logout ologout;
	@Test(dataProvider = "credentials")
	public void f(String username1,String password1) throws InterruptedException, IOException {
		
		/*driver.get("https://phptravels.net/login");
		Assert.assertEquals(driver.getTitle(), "Login - PHPTRAVELS");
		Reporter.log("<br>teststeppass::Sucessfully validated Title of page</br>");*/
		
	    ologin = new LoginPages(driver);
		ologin.login(username1, password1);
		Reporter.log("<br>teststeppass::Sucessfully validated the login page</br>");

	    obook = new MyBooking(driver);
		obook.setmybooking();
		Reporter.log("<br>teststeppass::Sucessfully validated the Booking page</br>");
		obook.viewmybooking();
		Reporter.log("<br>teststeppass::Sucessfully validated view vouchercode functionality</br>");

	    ofund = new AddFund(driver);
		ofund.addfund();
		driver.navigate().back();
		Reporter.log("<br>teststeppass::Sucessfully validated the AddFund page</br>");
		
        /*oprofile = new MyProfile(driver);
		oprofile.adddprofile();
		
		Reporter.log("<br>teststeppass::Sucessfully validated the My Profile page</br>");

        ologout = new Logout(driver);
		ologout.logout();
		Reporter.log("<br>teststeppass::Sucessfully validated the logout page</br>");*/

	}
	@DataProvider(name = "credentials")
	public Object[][] getData() {
		return new Object[][] { {"user@phptravels.com", "demouser" }};
		}


}
