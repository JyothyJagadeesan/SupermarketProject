package com.obsqura.pagescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']") WebElement userNameField;
	@FindBy(xpath="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signInButton;
	@FindBy(xpath="//p[text()='Purchased Packages']//ancestor::div[@class='small-box bg-info']") WebElement homePageElement ;
	@FindBy(xpath="//button[text()='Sign In']") WebElement loginPageElement ;
	
	public boolean toCheckWhetherTheElementExist()
	{
		boolean isHomePageElementDisplayed=homePageElement.isDisplayed();
		return isHomePageElementDisplayed;
	}
	
	public String toCheckWhetherWeAreStillOnLoginPage()
	{
		String actualValue=loginPageElement.getText();
		return actualValue;
	}
	
	public LoginPage enterUsernameOnUserfield(String userName)
	{
		userNameField.sendKeys(userName);
		return this;
		
	}
	public LoginPage  enterPasswordOnPasswordfield(String password)
	{
		passwordField.sendKeys(password);
		return this;
		
	}
	public LoginPage  clickOnSignInButton()
	{
		signInButton.click();
		return this;
	}
}
