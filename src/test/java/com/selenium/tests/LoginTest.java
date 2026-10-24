package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseTest;
import com.selenium.page.LoginPage;

public class LoginTest extends BaseTest
{
	@Test(groups = {"smoke"})
	public void validLoginTest()
	{
		LoginPage loginpage = new LoginPage(driver);
		
		loginpage.login("standard_user", "secret_sauce");
		 
		String actualURL = driver.getCurrentUrl();
		
		Assert.assertTrue(actualURL.contains("inventory.html"),
				"Login failed : Products page was not displayed");
	}
	
	@Test(groups = {"regression"})
	public void invalidTest()
	{
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("wrong_user", "wrong_pass");
		String actualError = loginpage.getErrorMessage();
		Assert.assertTrue(actualError.contains("Username and password do not match"),
				"Expected login error message was not displayed");
	}

}
  

