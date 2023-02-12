//Main class to check valid login functionality with all other test cases of stage1 with valid credentials

package com.tcs.phptravels.scripts;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tcs.phptravels.admin.pageclass.LoginPages;
import com.tcs.phptravels.admin.pageclass.MyBooking;
import com.tcs.phptravels.admin.pageclass.Website;

public class SecondMainclass3 extends TestBase1 {
	LoginPages ologin;
	MyBooking obook;
	Website oweb;

	@Test(dataProvider = "credentials")
	public void f(String username1, String password1) throws InterruptedException {

		// Assert.assertEquals(driver.getTitle(), "[[[Login - PHPTRAVELS]]");
		// Reporter.log("<br>teststeppass::Sucessfully validated Title of page</br>");

		ologin = new LoginPages(driver);
		ologin.login(username1, password1);
		obook = new MyBooking(driver);
		obook.clickbooking();
		obook.deletebooking();
		obook.pendingbooking();
		obook.setmybooking();

		oweb = new Website(driver);
		oweb.clickwebsite();

	}

	@DataProvider(name = "credentials")
	public Object[][] getData() {
		return new Object[][] { { "admin@phptravels.com", "demoadmin" } };
	}

}
