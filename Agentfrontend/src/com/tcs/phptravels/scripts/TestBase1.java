package com.tcs.phptravels.scripts;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;



public class TestBase1 {
WebDriver driver;
WebDriverWait wait;

@Parameters("sbrowser")
@BeforeTest
public void beforeTest(String sbrowser) {
	if (sbrowser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "F:\\AutomationUtils\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if (sbrowser.equalsIgnoreCase("ie")) {
		System.setProperty("webdriver.ie.driver", "F:\\AutomationUtils\\Drivers\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
	} else if (sbrowser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver", "F:\\AutomationUtils\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	} else {
		System.out.println("pls provide a valid browser");
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

}

@AfterTest
public void exit()
{
	driver.close();
}
}
