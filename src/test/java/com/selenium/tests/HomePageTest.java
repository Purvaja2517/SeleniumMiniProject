package com.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.base.BaseTest;

public class HomePageTest extends BaseTest 
{
	@Test(groups={"smoke"})
	public void verifyHomePageTitle()
	{
		String title= driver.getTitle();
		System.out.println("Page Title: " + title);

        Assert.assertEquals(title, "Swag Labs");
	}

}
