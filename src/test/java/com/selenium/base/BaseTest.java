package com.selenium.base;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.selenium.utilities.BrowserFactory;
import com.selenium.utilities.ConfigReader;

import org.testng.annotations.AfterMethod;
public class BaseTest 
{
	protected WebDriver driver;
	@BeforeMethod(alwaysRun = true, onlyForGroups = {"smoke","regression"})
	public void setUp()
	{
		System.out.println("BaseTest setup is executing");
		//----read config details from properties file------
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");
		
		driver= BrowserFactory.createDriver(browser);
		
		/*
		 * if(browser.equalsIgnoreCase(browser)) { driver = new ChromeDriver(); } else {
		 * throw new IllegalArgumentException("Unsupported browser: "+browser); }
		 */
		driver.manage().window().maximize();
		driver.get(url);
		
		//---tradional way of invoking browser------
		/*driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");*/
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		if(driver != null)
		{
			driver.quit();
		}
	}

}
