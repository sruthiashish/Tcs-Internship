package com.tcs.phptravels.scripts;

import java.io.IOException;

import com.tcs.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.tcs.phptravels.customer.pageclass.LoginPages;
import com.tcs.phptravels.customer.pageclass.Logout;
import com.tcs.phptravels.customer.pageclass.MyProfile;

public class Testclass1_Excelupdateaddress extends TestBase1 {
	LoginPages objlogin;
	MyProfile oprofile;

	@Test
	public void verifyvalidlogin() throws IOException, InterruptedException {

		ExcelUtility oexxcelutility = new ExcelUtility("C:\\Users\\Hp\\Desktop\\testdata.xlsx", "php");

		objlogin = new LoginPages(driver);
		oprofile = new MyProfile(driver);
		Logout ologout = new Logout(driver);
		String username1 = oexxcelutility.getExcelData(0, 0);
		String password1 = oexxcelutility.getExcelData(0, 1);
		String address1 = oexxcelutility.getExcelData(0, 2);
		objlogin.login(username1, password1);
		oprofile.adddprofile();
		oprofile.updateprofile(address1);
		Reporter.log("<br>teststeppass::Sucessfully validated the profile page</br>");
		ologout = new Logout(driver);
		ologout.logout();
		Reporter.log("<br>teststeppass::Sucessfully validated the logout page</br>");
	}

//}
}
