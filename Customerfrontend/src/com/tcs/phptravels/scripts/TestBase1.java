package com.tcs.phptravels.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class TestBase1 {
WebDriver driver;
WebDriverWait wait;
public static Properties prop=null;


public static void TestBase()
{
	try {
	prop= new Properties();
	//FileInputStream ip = new FileInputStream(System.getProperty(("user.dir")+"/src/test/resources"+"/config.properies"));
	FileInputStream ip = new FileInputStream("C:\\\\Users\\\\Hp\\\\Desktop\\\\config.properties");
	prop.load(ip);
}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
		// TODO: handle exception
	}
@BeforeTest
public void  onsetup()
{
	TestBase();

	String browserName=
			prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{   
		System.setProperty("webdriver.chrome.driver", "F:\\AutomationUtils\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}else if (browserName.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", "F:\\AutomationUtils\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	driver.get(prop.getProperty("url"));
	driver.manage().window().maximize();
	
}

@AfterTest
public void exit()
{
	driver.quit();
}
}
