package com.selenium.page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	WebDriverWait wait;
	
	By username = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	By errorMessages = By.cssSelector("[data-test='error']");
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	public void enterUserName(String user)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(username)).sendKeys(user);
		//driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys(pass);;
		//driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
		//driver.findElement(loginButton).click();
	}
	
	public void login(String user, String pass)
	{
		enterUserName(user);
		enterPassword(pass);
		clickLogin();
	}
	
	public String getErrorMessage()
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessages)).getText();
	}
	

}
