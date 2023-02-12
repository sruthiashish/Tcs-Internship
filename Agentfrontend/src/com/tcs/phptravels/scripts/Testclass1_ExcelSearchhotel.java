package com.tcs.phptravels.scripts;

import java.io.IOException;

import com.tcs.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tcs.phptravels.agent.pageclass.Blogs;
import com.tcs.phptravels.agent.pageclass.Flights;
import com.tcs.phptravels.agent.pageclass.Homepage;
import com.tcs.phptravels.agent.pageclass.HotelPage;
import com.tcs.phptravels.agent.pageclass.LoginPages;
import com.tcs.phptravels.agent.pageclass.Offers;
import com.tcs.phptravels.agent.pageclass.Tours;
import com.tcs.phptravels.agent.pageclass.Visa;

public class Testclass1_ExcelSearchhotel extends TestBase1 {
	LoginPages objlogin;
	Homepage ohome;
	HotelPage ohotel;
	Tours otour;
	Flights oflight;
	Visa ovisa;
	Blogs oblogs;
	Offers oofers;

	@Test
	public void verifyvalidlogin() throws IOException, InterruptedException {
		driver.get("https://phptravels.net/login");	
		driver.manage().window().maximize();
		ExcelUtility oexxcelutility = new ExcelUtility("C:\\Users\\Hp\\Desktop\\testdata1.xlsx", "php");

		objlogin = new LoginPages(driver);

		ohome = new Homepage(driver);
		driver.navigate().back();

		ohotel = new HotelPage(driver);

		otour = new Tours(driver);

		oflight = new Flights(driver);

		ovisa = new Visa(driver);

		oblogs = new Blogs(driver);

		oofers = new Offers(driver);

		String username1 = oexxcelutility.getExcelData(0, 0);
		String password1 = oexxcelutility.getExcelData(0, 1);
		String city = oexxcelutility.getExcelData(0, 2);
		String date1 = oexxcelutility.getExcelData(0, 3);
		String date2 = oexxcelutility.getExcelData(0, 4);

		objlogin.login(username1, password1);
		ohotel.Clickhotel();
		ohotel.Searchhotel(city, date1, date2);
		ohome.Clickhome();
		otour.Clicktours();
		oflight.Clickbtn();
		ovisa.ClickVisa();
		oblogs.Clickblog();
		oofers.Clickoffers();
	}

//}
}
